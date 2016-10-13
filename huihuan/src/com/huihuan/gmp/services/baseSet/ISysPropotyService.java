package com.huihuan.gmp.services.baseSet;

import java.util.List;
import java.util.Map;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.entity.Wrappers;
import com.huihuan.gmp.services.common.ICommService;

public interface ISysPropotyService extends ICommService{
	
	public Map getCodeTypes() throws ServiceException;

	public int saveCodeTypes(String productCodeType,String materialCodeType,String packageCodeType) throws ServiceException;

	public String getMachineCode() throws ServiceException;
	
	public Map getSysPropotys(String queryPage,
			String size,String keyword,String orderPropoty,String orderType)  throws ServiceException;
	
	public SysProperty getSysPropotysDetails(Long Id) throws ServiceException;
	
	public int deleteSysPropotyItem(String id) throws ServiceException;
	
	public int addSysPropotyItem(String  mlCd,String ky, String value,String rmk) throws ServiceException;
	
	public int editSysPropotyItem(String itemId,String  mlCd,String ky, String value,String rmk) throws ServiceException;
	
	
}
