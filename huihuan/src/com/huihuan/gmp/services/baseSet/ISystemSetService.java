package com.huihuan.gmp.services.baseSet;

import java.util.List;
import java.util.Map;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;

public interface ISystemSetService extends ICommService{
	public Map getSysPropotys()throws ServiceException;
	public int setRecipeSysPropoty(String a,String b,String c,String d,String e,String f) throws ServiceException;
	public int setProductSysPropoty(String a,String b,String c,String d,String e) throws ServiceException;
	public int setHrSysPropoty(String a,String b) throws ServiceException;	
	public int setProductEditSysPropoty(String a) throws ServiceException;
	public int setPackingEditSysPropoty(String a) throws ServiceException;
	public int setMaterialEditSysPropoty(String a,String b) throws ServiceException;
}