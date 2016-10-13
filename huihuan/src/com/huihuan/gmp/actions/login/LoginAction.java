package com.huihuan.gmp.actions.login;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.huihuan.common.util.http.HttpClientConnectionManager;
import com.huihuan.framework.configurer.Configure;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.cst.Constants;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.Login.ILoginService;

public class LoginAction extends BaseAction {
	
	

	@Resource
	private ILoginService loginService;
	
	private BaseJson queryJson = new BaseJson();

	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}

	public String returnLoginID() throws ServiceException {
		queryJson = new BaseJson();
		HttpSession session = getHttpRequest().getSession(); 
	    long id=Long.parseLong(session.getAttribute(Constants.USER_Id).toString());
	    queryJson.setObj(id);
	    return "jsonResult";
	}
	
	public String returnLoginName() throws ServiceException {
		queryJson = new BaseJson();
		HttpSession session = getHttpRequest().getSession(); 
	    String idStr=session.getAttribute(Constants.USER_Id).toString();
	    String loginName=loginService.getUsername(Long.parseLong(idStr));
	    queryJson.setObj(loginName);
	    return "jsonResult";
	}
	
	public String login() throws ServiceException {
		queryJson = new BaseJson();
		try {	
			String name=getHttpRequest().getParameter("name");
			String pwd=getHttpRequest().getParameter("pwd");
			int result=loginService.login(name,pwd);
			if(result==-1){
			    queryJson.setRetcode("0001");
			    queryJson.setErrorMsg("该用户名不存在");
			}
			else if(result==0){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("密码错误");
			}
			else{
				queryJson.setRetcode("0000");
				writeSession(Constants.USER_Id, result);
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

	public String logout(){
		getHttpRequest().getSession().invalidate();
		return "logout";
	}

    public String getUserInfo() {
    	queryJson = new BaseJson();
		try {      
			String code = getHttpRequest().getParameter("code");
			String state = getHttpRequest().getParameter("state");
			String url="STATE";
			if(!state.equals("STATE")){
				String s[]=state.split("/");
				url=s[s.length-1];
				System.out.println("state是:"+url);
			}			
			String result = loginService.getUserInfo(code);
			if (result==null) {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("账号不存在");
				getHttpResponse().sendRedirect("/huihuan/web/jsp/error.jsp");
			}
			else {
				queryJson.setRetcode("0000");
			    writeSession(Constants.USER_Id, result);
			    if(!state.equals("STATE")){
			    	getHttpResponse().sendRedirect("/huihuan/web/jsp/"+url);
			    }
			    else{
			    	getHttpResponse().sendRedirect("/huihuan/web/jsp/main.jsp");
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
