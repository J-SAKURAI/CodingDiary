package com.huihuan.gmp.services.baseSet;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.MaterialCatagoryDetails;
import com.huihuan.gmp.entity.Materials;
import com.huihuan.gmp.entity.MaterialsHsty;
import com.huihuan.gmp.services.common.ICommService;

public interface IMaterialsService extends ICommService {
	
//	public List<Materials> getMaterialsByType(int type) throws ServiceException;
	
	public List<Materials> getMaterialDetails()throws ServiceException;
//	
//	public List<Materials> getMaterialDetails(String Id)throws ServiceException;
//
//	
//	public List<Materials> getMaterialDetails1(String Id,String state,String kw) throws ServiceException;
	
	
	public int addMaterialDetail(String catagoryId,String name,String quantityUnit1,String quantityUnit2,String catagoryCode,String code,
			String isMiddle,String productId,String userDefinedCode,String usedName,String preUnitCnvrsnFctr,String unitCnvrsnFctr,
			String baseQuantityUnit,String isRepeatWeight,String toleranceRange,String repeatWeightFormula,
			String supplementFormula,String specialManageType,String minInventory,String maxInventory,String storageCondition,
			String warmingDay,String status,String validityPeriod,String photoUrl,String validityManageType,String machineCode,String userId)throws ServiceException;
	
	
	
	
	
	public int updateMaterialDetail(String Id,String name,String quantityUnit1,String quantityUnit2,String catagoryCode,String code,
			String isMiddle,String productId,String userDefinedCode,String usedName,String preUnitCnvrsnFctr,String unitCnvrsnFctr,
			String baseQuantityUnit,String isRepeatWeight,String toleranceRange,String repeatWeightFormula,
			String supplementFormula,String specialManageType,String minInventory,String maxInventory,String storageCondition,
			String warmingDay,String status,String validityPeriod,String photoUrl,String validityManageType,String userId)throws ServiceException;
	
	
	

	public List<MaterialCatagoryDetails> getMaterialCatagoryDetail(Long Id)throws ServiceException;

	public CatagoryDetails getCatagoryDetail(Long catagoryId) throws ServiceException;
	public int deleteMaterialDetail(String Id) throws ServiceException;
	
	public Materials getMaterialsDetails(Long Id)throws ServiceException;
	
	public MaterialsHsty getMaterialsHstyDetails(Long Id)throws ServiceException;
	
	public Map getMaterials(String catagoryDetails,String queryPage,String size,String keyword,String status,String orderPropoty,String orderType);
	
	public String getProductName(String materialID) throws ServiceException;
	
	public int check(String id,String userId) throws ServiceException;
	
	public String getCurrentCode(String catagoryDetails) throws ServiceException;
}
