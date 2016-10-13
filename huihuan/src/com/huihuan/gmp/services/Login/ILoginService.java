package com.huihuan.gmp.services.Login;

import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;

public interface ILoginService extends ICommService {

	public String getUsername(Long id) throws ServiceException;
	
	//返回登录名(username)
	public String getLoginName(Long id) throws ServiceException;
	public String getUserInfo(String code) throws ServiceException;
	public int login(String name,String pwd) throws ServiceException;
}
