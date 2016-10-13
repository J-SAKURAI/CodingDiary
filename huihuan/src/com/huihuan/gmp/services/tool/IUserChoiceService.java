package com.huihuan.gmp.services.tool;


import java.util.Map;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;

public interface IUserChoiceService extends ICommService{
	
	
	public int setSysPropotys(Long id,String defaultmenu,String productcodecheck)  throws ServiceException; //,String initialpage
	public Map getSysPropotys(Long id)  throws ServiceException;
	

}
