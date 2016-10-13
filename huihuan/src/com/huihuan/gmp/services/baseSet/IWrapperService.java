package com.huihuan.gmp.services.baseSet;

import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.MaterialCatagoryDetails;
import com.huihuan.gmp.entity.WrapperCatagoryDetails;
import com.huihuan.gmp.entity.Wrappers;
import com.huihuan.gmp.entity.WrappersHsty;
import com.huihuan.gmp.services.common.ICommService;

public interface IWrapperService extends ICommService {
	
	
	
	public int addWrapperDetail(String catagoryId,String name,String quantityUnit1,String quantityUnit2, String catagoryCode,String code,String userDefinedCode, String usedName,
			String preUnitCnvrsnFctr,String unitCnvrsnFctr,String baseQuantityUnit, String isRepeatWeight, String toleranceRange,
			String repeatWeightFormula, String specialManageType,
			String status,String machineCode,String userId)throws ServiceException;
	
	
	public int updateWrapperDetail(String Id,String name, String quantityUnit1,String quantityUnit2, String catagoryCode,String code,String userDefinedCode, String usedName,
			String preUnitCnvrsnFctr,String unitCnvrsnFctr,String baseQuantityUnit, String isRepeatWeight, String toleranceRange,
			String repeatWeightFormula, String specialManageType,
			String status,String userId)throws ServiceException;
	
	
	
	public List<WrapperCatagoryDetails> getWrapperCatagoryDetail(Long Id)throws ServiceException;

	public int deleteWrapperDetail(String Id)throws ServiceException;
	
	public Wrappers getWrappersDetails(Long Id)throws ServiceException;
	
	public WrappersHsty getWrappersHstyDetails(Long Id)throws ServiceException;
	
	public CatagoryDetails getCatagoryDetail(Long catagoryId) throws ServiceException;
	
	public Map getWrappers(String catagoryDetails,String queryPage,String size,String keyword,String status,String orderPropoty,String orderType);

	public int check(String id,String userId) throws ServiceException;
	
	public String getCurrentCode(String catagoryDetails) throws ServiceException;

}
