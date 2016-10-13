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
import com.huihuan.gmp.entity.Users;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.tool.IUserChoiceService;


@Service(value = "userChoiceService")
public class UserChoiceImpl extends CommServiceImpl implements IUserChoiceService {

	@Resource
	SysPropotyDao sysPropotyDao;

	public int setSysPropotys(Long id,String strdefaultmenu,String strproductcodecheck)  throws ServiceException{
		Users user = baseDAO.findById(id, Users.class);
		if(!StringUtil.isEmpty(strdefaultmenu)){
			int defaultmenu=Integer.parseInt(strdefaultmenu);
		    user.setMenuStyle(defaultmenu);
		}
		
		if(!StringUtil.isEmpty(strproductcodecheck)){
			int productcodecheck=Integer.parseInt(strproductcodecheck);
			user.setToolBar(productcodecheck);
		}
		/*if(!StringUtil.isEmpty(initialpage)){
			propertyList=baseDAO.findByProperty("propotyKey", "startpage", Users.class);
			if(propertyList.size()>0){
				propertyList.get(0).setPropotyVl(initialpage);
				baseDAO.update(propertyList.get(0));
			}
		}*/
			
		return 0;
	}
	
	public Map getSysPropotys(Long id)  throws ServiceException{
		int defaultmenu,productcodecheck; //,initialpage
		Users user = baseDAO.findById(id, Users.class);
		defaultmenu=user.getMenuStyle();
		productcodecheck=user.getToolBar();
		/*propertyList=baseDAO.findByProperty("propotyKey", "startpage", Users.class);
		initialpage=propertyList.get(0).getPropotyVl();*/
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("defaultmenu", defaultmenu);
		map.put("productcodecheck", productcodecheck);
		//map.put("initialpage", initialpage);
		return map;

	}
}

