package com.huihuan.gmp.services.tool;

import java.util.List;
import java.util.Map;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.entity.Wrappers;
import com.huihuan.gmp.services.common.ICommService;

public interface IManageToolService extends ICommService{
	
	
	public int setSysPropotys(String pwdminlength,String pwdvalidday,String pwderrormaxcount,String pwdminintensity,String displayidentycode)  throws ServiceException;
	public Map getSysPropotys()  throws ServiceException;
	

}
