package com.huihuan.gmp.actions.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.cst.Constants;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.tool.IPwdModifyService;

public class PwdModifyAction extends BaseAction{
	
	@Resource
	private IPwdModifyService pwdModifyService;
	
	private BaseJson queryJson = new BaseJson();

	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
    
	public String getPwdPropotys() {
		queryJson =new BaseJson();
		try {
			Map result=pwdModifyService.getPwdPropotys();       
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	public String getUserName(){
		queryJson = new BaseJson();
		try {
			HttpSession session = getHttpRequest().getSession(); 
		    Long id=Long.parseLong(session.getAttribute(Constants.USER_Id).toString());			
			String username = pwdModifyService.getUserName(id);
			if (!username.equals("")) {
				queryJson.setRetcode("0000");
				queryJson.setObj(username);
			}
			else {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("无法获得用户名");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			queryJson.setRetcode("0003");
			queryJson.setErrorMsg("服务器连接异常");
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			queryJson.setRetcode("0003");
			queryJson.setErrorMsg("服务器连接异常");
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String modifyPwd(){
		queryJson = new BaseJson();
		try {
			HttpSession session = getHttpRequest().getSession(); 
		    Long id=Long.parseLong(session.getAttribute(Constants.USER_Id).toString());
			String oldpwd = getHttpRequest().getParameter("oldpwd");
			String newpwd = getHttpRequest().getParameter("newpwd");
			String confirmpwd = getHttpRequest().getParameter("confirmpwd");			
			int result = pwdModifyService.checkPwd(id,oldpwd);
			if (result == -1&&(!newpwd.equals(confirmpwd))) {
				queryJson.setRetcode("0004");
				queryJson.setErrorMsg("密码不正确\n两次密码输入不一致");
			}
			else if (result == -1) {
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("密码不正确");
			}
			else if(!newpwd.equals(confirmpwd)){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("两次密码输入不一致");
			}
			else{
				int modifyresult=pwdModifyService.modifyPwd(id,newpwd);
				if(modifyresult==1){
					queryJson.setRetcode("0000");
				}
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			queryJson.setRetcode("0003");
			queryJson.setErrorMsg("服务器连接异常");
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			queryJson.setRetcode("0003");
			queryJson.setErrorMsg("服务器连接异常");
			e.printStackTrace();
		}
		return "jsonResult";
	}

}
