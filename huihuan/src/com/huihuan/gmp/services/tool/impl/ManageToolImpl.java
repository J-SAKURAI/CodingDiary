package com.huihuan.gmp.services.tool.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huihuan.common.util.DateUtil;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.SYS_PROPERTY;
import com.huihuan.gmp.daos.baseSet.SysPropotyDao;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.tool.IManageToolService;


@Service(value = "manageToolService")
public class ManageToolImpl extends CommServiceImpl implements IManageToolService {

	@Resource
	SysPropotyDao sysPropotyDao;

	public int setSysPropotys(String pwdminlength,String pwdvalidday,String pwderrormaxcount,String pwdminintensity,String displayidentycode)  throws ServiceException{
		List<SysProperty> propertyList;
		
		if(!StringUtil.isEmpty(pwdminlength)){
			propertyList=baseDAO.findByProperty("propotyKey", "PWD_MIN_LENGTH", SysProperty.class);
			if(propertyList.size()>0){
				propertyList.get(0).setPropotyVl(pwdminlength);
				baseDAO.update(propertyList.get(0));
			}
		}
		
		if(!StringUtil.isEmpty(pwdvalidday)){
			propertyList=baseDAO.findByProperty("propotyKey", "PWD_VALID_DAY", SysProperty.class);
			if(propertyList.size()>0){
				propertyList.get(0).setPropotyVl(pwdvalidday);
				baseDAO.update(propertyList.get(0));
			}
		}
		if(!StringUtil.isEmpty(pwderrormaxcount)){
			propertyList=baseDAO.findByProperty("propotyKey", "PWD_ERROR_MAX_COUNT", SysProperty.class);
			if(propertyList.size()>0){
				propertyList.get(0).setPropotyVl(pwderrormaxcount);
				baseDAO.update(propertyList.get(0));
			}
		}
		
		if(!StringUtil.isEmpty(pwdminintensity)){
			propertyList=baseDAO.findByProperty("propotyKey", "PWD_MIN_INTENSITY", SysProperty.class);
			if(propertyList.size()>0){
				propertyList.get(0).setPropotyVl(pwdminintensity);
				baseDAO.update(propertyList.get(0));
			}
		}
		
		if(!StringUtil.isEmpty(displayidentycode)){
			propertyList=baseDAO.findByProperty("propotyKey", "DISPLAY_IDENTY_CODE", SysProperty.class);
			if(propertyList.size()>0){
				propertyList.get(0).setPropotyVl(displayidentycode);
				baseDAO.update(propertyList.get(0));
			}
		}		
		return 0;
	}
	
	public Map getSysPropotys()  throws ServiceException{
		String pwdminlength,pwdvalidday,pwderrormaxcount,pwdminintensity,displayidentycode;
		List<SysProperty> propertyList;
		propertyList=baseDAO.findByProperty("propotyKey", "PWD_VALID_DAY", SysProperty.class);
		pwdminlength=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey", "PWD_VALID_DAY", SysProperty.class);
		pwdvalidday=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey", "PWD_ERROR_MAX_COUNT", SysProperty.class);
		pwderrormaxcount=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey", "PWD_MIN_INTENSITY", SysProperty.class);
		pwdminintensity=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey", "DISPLAY_IDENTY_CODE", SysProperty.class);
		displayidentycode=propertyList.get(0).getPropotyVl();
		Map<String,String> map=new HashMap<String,String>();
		map.put("pwdminlength", pwdminlength);
		map.put("pwdvalidday", pwdvalidday);
		map.put("pwderrormaxcount", pwderrormaxcount);
		map.put("pwdminintensity", pwdminintensity);
		map.put("displayidentycode", displayidentycode);
		return map;

	}
}

