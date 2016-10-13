package com.huihuan.gmp.actions.authority;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.huihuan.common.util.StringUtil;
import com.huihuan.gmp.cst.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * File name：SessionAuthorityInterceptor
 * Date: 2012-4-25
 * Author: Administrator
 * Description：AJAX请求拦截器
 * Modify History:
 */
public class AjaxAuthorityInterceptor extends AbstractInterceptor {

	private static final Log log = LogFactory.getLog(AjaxAuthorityInterceptor.class);
	
	/**
	 * Interrcept拦截器
	 */
	public String intercept(ActionInvocation invocation){
				
		String result="";
		String reqUrl = invocation.getProxy().getActionName();
		String method = invocation.getProxy().getMethod();
		String action = reqUrl.substring(0,reqUrl.indexOf("_"));
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		// 判断session是否存在及session中的user信息是否存在，如果存在不用拦截
		String userId = session.getAttribute(Constants.USER_Id)+"";
		try {
			result= invocation.invoke();
			/*if (!StringUtil.isBlank(userId)&&!"null".equals(userId)||"loginAction".equals(action)) {
				result= invocation.invoke();
			} else {
				if (isAjaxRequest(request)) {
					if (action.contains("loginAction")) {
						result= invocation.invoke();
					}
					//response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf50f9348e644a495&redirect_uri=http%3a%2f%2fwww.shmlhw.com%2fhuihuan%2floginAction_getUserInfo&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
					response.setHeader("sessionstatus", "timeout");
					response.sendError(518, "session timeout.");
					return null;
				}
			}*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean isAjaxRequest(HttpServletRequest request){
		String header = request.getHeader("X-Requested-With");
		if(header != null && "XMLHttpRequest".equals(header))
			return true;
		else
			return false;
	}

}
