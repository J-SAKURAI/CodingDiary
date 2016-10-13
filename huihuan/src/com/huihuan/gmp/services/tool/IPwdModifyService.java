package com.huihuan.gmp.services.tool;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.Constants;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.common.ICommService;

public interface IPwdModifyService extends ICommService{
	
	public int checkPwd(Long id,String password) throws ServiceException;
	public int modifyPwd(Long id,String newpwd) throws ServiceException;
	public String getUserName(Long id) throws ServiceException;
	public Map getPwdPropotys() throws ServiceException;

}
