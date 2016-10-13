package com.huihuan.gmp.actions.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.cst.Constants;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.tool.IUserChoiceService;

import java.io.IOException;
import java.io.IOException;
public class UserChoiceAction extends BaseAction {
private BaseJson queryJson =new BaseJson();
	
	@Resource
	IUserChoiceService userChoiceService;
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String setSysPropoty(){
		queryJson =new BaseJson();
		try {
			HttpSession session = getHttpRequest().getSession(); 
		    Long id=Long.parseLong(session.getAttribute(Constants.USER_Id).toString());
			String defaultmenu=getHttpRequest().getParameter("defaultmenu");
			String productcodecheck=getHttpRequest().getParameter("productcodecheck");
			String initialpage=getHttpRequest().getParameter("initialpage");
			int result=userChoiceService.setSysPropotys(id,defaultmenu,productcodecheck); //,initialpage
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("修改失败！");
            if(result==0)
            	queryJson.setRetcode("0000");           
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getSysPropotys(){
		queryJson =new BaseJson();
		try {
			HttpSession session = getHttpRequest().getSession(); 
		    Long id=Long.parseLong(session.getAttribute(Constants.USER_Id).toString());
			Map result=userChoiceService.getSysPropotys(id);       
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
}
