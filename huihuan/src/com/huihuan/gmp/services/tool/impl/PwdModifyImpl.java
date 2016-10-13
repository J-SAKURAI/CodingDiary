package com.huihuan.gmp.services.tool.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.Constants;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.entity.Users;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.tool.IPwdModifyService;

@Service(value = "pwdModifyService")
public class PwdModifyImpl extends CommServiceImpl implements IPwdModifyService{
	
	public Map getPwdPropotys() {
		String pwdminlength,pwdminintensity;
		List<SysProperty> propertyList;
		propertyList=baseDAO.findByProperty("propotyKey", "PWD_MIN_LENGTH", SysProperty.class);
		pwdminlength=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey", "PWD_MIN_INTENSITY", SysProperty.class);
		pwdminintensity=propertyList.get(0).getPropotyVl();
		Map<String,String> map=new HashMap<String,String>();
		map.put("pwdminlength", pwdminlength);
		map.put("pwdminintensity", pwdminintensity);
		return map;
	}
	
	public int checkPwd(Long id,String oldpwd) {
		Users user = baseDAO.findById(id, Users.class);
		if(user.getPassword().equals(oldpwd))
			 return user.getId().intValue();//正确		
		return -1;//密码不正确
	}
	
	public int modifyPwd(Long id,String newpwd) {
		Users user = baseDAO.findById(id, Users.class);
	    user.setPassword(newpwd);
	    return 1;
	}
	
	public String getUserName(Long id) {
		String username;
		Users user = baseDAO.findById(id, Users.class);
	    username = user.getUsername();
	    return username;
	}

}
