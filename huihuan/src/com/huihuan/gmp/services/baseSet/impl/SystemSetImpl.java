package com.huihuan.gmp.services.baseSet.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.huihuan.common.util.DateUtil;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.CATAGORY_TYPE;
import com.huihuan.gmp.cst.STATUS;
import com.huihuan.gmp.cst.SYS_PROPERTY;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.Const;
import com.huihuan.gmp.entity.Products;
import com.huihuan.gmp.entity.SameCatagories;
import com.huihuan.gmp.entity.SameCatagorysDetails;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.entity.Units;
import com.huihuan.gmp.entity.Users;
import com.huihuan.gmp.services.baseSet.ICatagoryService;
import com.huihuan.gmp.services.baseSet.IConstService;
import com.huihuan.gmp.services.baseSet.IProductService;
import com.huihuan.gmp.services.baseSet.ISameCatagoryService;
import com.huihuan.gmp.services.baseSet.ISystemSetService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.vo.ConstVo;
import com.huihuan.gmp.vo.ProductVo;
import com.huihuan.gmp.vo.SameCatagoryVo;

@Service(value = "systemSetService")
public class SystemSetImpl extends CommServiceImpl implements ISystemSetService{

	@Override
	public Map getSysPropotys() throws ServiceException {
		// TODO Auto-generated method stub
		String feeddifference;
		String isFeedDifferenceControl;
		String isEditRecipe1;
		String isEditRecipe2;
		String editRecipe1;
		String editRecipe2;
		String isMaterialCodingEditChecked;
		String isPackingDefine1;
		String isPackingDefine2;
		String packingDefine1;
		String packingDefine2;
		String defaultPasswd;
		String isEmployeeECard;
		String isProductEditChecked;
		String isMaterialEditChecked;
		String isMaterialNameSave;
		String isPackingEditChecked;
		List<SysProperty> propertyList;
		
		propertyList=baseDAO.findByProperty("propotyKey",SYS_PROPERTY.FEED_DIFFERENCE, SysProperty.class);
		feeddifference=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey",SYS_PROPERTY.IS_FEED_DIFFERENCE_CONTROL, SysProperty.class);
		isFeedDifferenceControl=propertyList.get(0).getPropotyVl();		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_EDIT_RECIPE1, SysProperty.class);
		isEditRecipe1=propertyList.get(0).getPropotyVl();		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_EDIT_RECIPE2, SysProperty.class);
		isEditRecipe2=propertyList.get(0).getPropotyVl();		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.EDIT_RECIPE1, SysProperty.class);
		editRecipe1=propertyList.get(0).getPropotyVl();		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.EDIT_RECIPE2, SysProperty.class);
		editRecipe2=propertyList.get(0).getPropotyVl();	
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_MATERIAL_EDIT_CHECKED, SysProperty.class);
		isMaterialEditChecked=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_PACKING_DEFINE1, SysProperty.class);
		isPackingDefine1=propertyList.get(0).getPropotyVl();	
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_PACKING_DEFINE2, SysProperty.class);
		isPackingDefine2=propertyList.get(0).getPropotyVl();	
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.PACKING_DEFINE1, SysProperty.class);
		packingDefine1=propertyList.get(0).getPropotyVl();	
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.PACKING_DEFINE2, SysProperty.class);
		packingDefine2=propertyList.get(0).getPropotyVl();	
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.DEFAULT_PASSWD, SysProperty.class);
		defaultPasswd=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_EMPLOYEE_E_CARD, SysProperty.class);
		isEmployeeECard=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_PRODUCT_EDIT_CHECK, SysProperty.class);
		isProductEditChecked=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey",SYS_PROPERTY.IS_MATERIAL_EDIT_CHECKED, SysProperty.class);
		isMaterialCodingEditChecked=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_MATERIAL_NAME_SAVE, SysProperty.class);
		isMaterialNameSave=propertyList.get(0).getPropotyVl();
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_PACKAGE_EDIT_CHECK, SysProperty.class);
		isPackingEditChecked=propertyList.get(0).getPropotyVl();
		
		
		
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("feeddifference", feeddifference);
		map.put("isFeedDifferenceControl", isFeedDifferenceControl);
		map.put("isEditRecipe1", isEditRecipe1);
		map.put("isEditRecipe2", isEditRecipe2);
		map.put("editRecipe1", editRecipe1);
		map.put("editRecipe2", editRecipe2);
		map.put("isMaterialEditChecked", isMaterialEditChecked);
		map.put("isPackingDefine1", isPackingDefine1);
		map.put("isPackingDefine2", isPackingDefine2);
		map.put("packingDefine1", packingDefine1);
		map.put("packingDefine2", packingDefine2);
		map.put("defaultPasswd", defaultPasswd);
		map.put("isEmployeeECard", isEmployeeECard);
		map.put("isProductEditChecked", isProductEditChecked);
		map.put("isMaterialCodingEditChecked", isMaterialCodingEditChecked);
		map.put("isMaterialNameSave", isMaterialNameSave);
		map.put("isPackingEditChecked", isPackingEditChecked);
		return map;
	}

	public int setRecipeSysPropoty(String feeddifference,String isFeedDifferenceControl,String isEditRecipe1
			,String editRecipe1,String isEditRecipe2,String editRecipe2) throws ServiceException
	{
		List<SysProperty> propertyList;
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_FEED_DIFFERENCE_CONTROL, SysProperty.class);
		propertyList.get(0).setPropotyVl(isFeedDifferenceControl);
		baseDAO.save(propertyList.get(0));	
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.FEED_DIFFERENCE, SysProperty.class);
		propertyList.get(0).setPropotyVl(feeddifference);
		baseDAO.save(propertyList.get(0));
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_EDIT_RECIPE1, SysProperty.class);
		propertyList.get(0).setPropotyVl(isEditRecipe1);
		baseDAO.save(propertyList.get(0));
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.EDIT_RECIPE1, SysProperty.class);
		propertyList.get(0).setPropotyVl(editRecipe1);
		baseDAO.save(propertyList.get(0));
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_EDIT_RECIPE2, SysProperty.class);
		propertyList.get(0).setPropotyVl(isEditRecipe2);
		baseDAO.save(propertyList.get(0));
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.EDIT_RECIPE2, SysProperty.class);
		propertyList.get(0).setPropotyVl(editRecipe2);
		baseDAO.save(propertyList.get(0));
		return 0;
	}
	
	public int setProductSysPropoty(String isMaterialEditChecked,String isPackingDefine1,String packingDefine1
			,String isPackingDefine2,String packingDefine2) throws ServiceException
	{
		List<SysProperty> propertyList;
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_MATERIAL_EDIT_CHECKED, SysProperty.class);
		propertyList.get(0).setPropotyVl(isMaterialEditChecked);
		baseDAO.save(propertyList.get(0));	
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_PACKING_DEFINE1, SysProperty.class);
		propertyList.get(0).setPropotyVl(isPackingDefine1);
		baseDAO.save(propertyList.get(0));
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.PACKING_DEFINE1, SysProperty.class);
		propertyList.get(0).setPropotyVl(packingDefine1);
		baseDAO.save(propertyList.get(0));
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_PACKING_DEFINE2, SysProperty.class);
		propertyList.get(0).setPropotyVl(isPackingDefine2);
		baseDAO.save(propertyList.get(0));
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.PACKING_DEFINE2, SysProperty.class);
		propertyList.get(0).setPropotyVl(packingDefine2);
		baseDAO.save(propertyList.get(0));
		return 0;
	}
	
	public int setHrSysPropoty(String defaultPasswd,String isEmployeeECard) throws ServiceException
	{
		List<SysProperty> propertyList;
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.DEFAULT_PASSWD, SysProperty.class);
		propertyList.get(0).setPropotyVl(defaultPasswd);
		baseDAO.save(propertyList.get(0));	
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_EMPLOYEE_E_CARD, SysProperty.class);
		propertyList.get(0).setPropotyVl(isEmployeeECard);
		baseDAO.save(propertyList.get(0));
		
		
		return 0;
	}
	public int setProductEditSysPropoty(String isProductEditChecked) throws ServiceException
	{
		List<SysProperty> propertyList;
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_PRODUCT_EDIT_CHECK, SysProperty.class);
		propertyList.get(0).setPropotyVl(isProductEditChecked);
		baseDAO.save(propertyList.get(0));	
				
		return 0;
	}
	public int setPackingEditSysPropoty(String isPackingEditChecked) throws ServiceException
	{
		List<SysProperty> propertyList;
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_PACKAGE_EDIT_CHECK, SysProperty.class);
		propertyList.get(0).setPropotyVl(isPackingEditChecked);
		baseDAO.save(propertyList.get(0));			
		return 0;
	}
	
	public int setMaterialEditSysPropoty(String isMaterialCodingEditChecked,String isMaterialNameSave) throws ServiceException
	{
		List<SysProperty> propertyList;
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_MATERIAL_EDIT_CHECKED, SysProperty.class);
		propertyList.get(0).setPropotyVl(isMaterialCodingEditChecked);
		baseDAO.save(propertyList.get(0));	
		
		propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.IS_MATERIAL_NAME_SAVE, SysProperty.class);
		propertyList.get(0).setPropotyVl(isMaterialNameSave);
		baseDAO.save(propertyList.get(0));
		
		
		return 0;
	}
}