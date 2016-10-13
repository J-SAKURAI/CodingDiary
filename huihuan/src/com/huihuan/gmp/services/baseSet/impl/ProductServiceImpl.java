package com.huihuan.gmp.services.baseSet.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
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
import com.huihuan.gmp.daos.baseSet.SysPropotyDao;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.Materials;
import com.huihuan.gmp.entity.Products;
import com.huihuan.gmp.entity.ProductsHsty;
import com.huihuan.gmp.entity.SameCatagories;
import com.huihuan.gmp.entity.SameCatagorysDetails;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.entity.Units;
import com.huihuan.gmp.services.baseSet.ICatagoryService;
import com.huihuan.gmp.services.baseSet.IProductService;
import com.huihuan.gmp.services.baseSet.ISameCatagoryService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.vo.ProductVo;
import com.huihuan.gmp.vo.SameCatagoryVo;

@Service(value = "productService")
public class ProductServiceImpl extends CommServiceImpl implements
		IProductService {

	private Log log = LogFactory.getLog(ProductServiceImpl.class);

	@Resource
	SysPropotyDao sysPropotyDao;
	
	@Override
	public String getProductPreCode(String sameCatagoryId) throws ServiceException {
		// TODO Auto-generated method stub
		if(!StringUtil.isEmpty(sameCatagoryId)){
			List<Products> list=baseDAO.findByHQL("from Products where sameCatagories.id=? order by code",new Object[]{Long.parseLong(sameCatagoryId)});
			if(list.size()==0){
				return "";
			}else{
				return list.get(list.size()-1).getCode();
			}
		}
		return "";
	}

	@Override
	public String getProductCodeLength() throws ServiceException {
		// TODO Auto-generated method stub
		String length = "";
		List<SysProperty> list = baseDAO.findByProperty("propotyKey",
				SYS_PROPERTY.PRDT_LNGTH, SysProperty.class);
		if (list.size() > 0) {
			SysProperty sysProperty = list.get(0);
			length = sysProperty.getPropotyVl();
		}
		return length;
	}

	@Override
	public Map getProducts(String catagoryDetails,String sameCatagoryId,String queryPage,String size,String keyword,String status,String orderPropoty,String orderType) throws ServiceException {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		int totalSize=0;
		List resultList=new ArrayList();
		int offset=-1;
		int pageSize=1;
		if(!StringUtil.isEmpty(size)){
			pageSize=Integer.parseInt(size);
		}
		if(!StringUtil.isEmpty(queryPage)){
			offset=(Integer.parseInt(queryPage)-1)*pageSize;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			List<String> sameCatagoryIdList=new ArrayList<String>();
			if(!StringUtil.isEmpty(sameCatagoryId)){
				sameCatagoryIdList = mapper.readValue(sameCatagoryId,
						List.class);
				sameCatagoryIdList.remove("null");
			}
			if(sameCatagoryIdList.size()>0){
				String sameCatagoryIds="(0";
				for(String id:sameCatagoryIdList){
					if(!StringUtil.isEmpty(id)){
						sameCatagoryIds+=","+id;
					}
				}
				sameCatagoryIds+=")";
				List params = new ArrayList();
				String sql="select t.id as id," +
						"t.code as code," +
						"t.name as name," +
						"t.quantityUnit1 as quantityUnit1," +
						"t.specialManageType as specialManageType," +
						"t.status as status " +
						"from (";
				sql+="select  " +
						"products.id as id,";
				String productCodeType=sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.PRODUCT_CODE_TYPE);
				if("0".equals(productCodeType)){
					sql+="products.MACHINE_CODE as code,";
				}else if("2".equals(productCodeType)){
					sql+="products.USER_DEFINED_CODE as code,";
				}else{
					sql+="CONCAT(same_catagories.CATAGORY_CODE,same_catagories.code,products.code) as code,";
				}
				sql+="CONCAT(same_catagories.name,' ',products.SPECIFICATION) as name," +
						"units.name as quantityUnit1," +
						"products.SPECIAL_MANAGE_TYPE as specialManageType," +
						"products.status as status " +
						"from products " +
						"left join units on products.QUANTITY_UNIT_ID1=units.id " +
						",same_catagories where products.SAME_CATAGORIE_ID=same_catagories.ID ";
				if(!StringUtil.isEmpty(status)){
					sql+="and products.status=?";
					params.add(status);
				}
				if(!StringUtil.isEmpty(keyword)){
					sql+="and products.name like ?";
					params.add("%"+keyword+"%");
				}
				sql+="and products.SAME_CATAGORIE_ID in "+sameCatagoryIds;
				sql+=") as t ";
				if(!StringUtil.isBlank(orderPropoty)){
					sql+="order by "+orderPropoty+" "+orderType;
				}
				resultList=baseDAO.findBySQLForVO(sql, 
						ProductVo.class, 
						params.toArray(),
						offset,
						pageSize);
				totalSize=baseDAO.getTotalSizeForSQL(sql, params.toArray());
			}else{
				List<String> catagoryDetailList=new ArrayList<String>();
				if(!StringUtil.isEmpty(catagoryDetails)){
					catagoryDetailList = mapper.readValue(catagoryDetails,
							List.class);
				}
				List params = new ArrayList();
				String sql="select t.id as id," +
						"t.code as code," +
						"t.name as name," +
						"t.quantityUnit1 as quantityUnit1," +
						"t.specialManageType as specialManageType," +
						"t.status as status " +
						"from (";
				sql += "select DISTINCT " +
						"products.id as id," +
						"CONCAT(same_catagories.CATAGORY_CODE,same_catagories.code,products.code) as code," +
						"CONCAT(same_catagories.name,' ',products.SPECIFICATION) as name," +
						"units.name as quantityUnit1," +
						"products.SPECIAL_MANAGE_TYPE as specialManageType," +
						"products.status as status " +
						"from products " +
						"left join units on products.QUANTITY_UNIT_ID1=units.id " +
						",same_catagories " +
						"where products.SAME_CATAGORIE_ID=same_catagories.ID ";
				if(!StringUtil.isEmpty(status)){
					sql+="and products.status=?";
					params.add(status);
				}
				if(!StringUtil.isEmpty(keyword)){
					sql+="and products.name like ?";
					params.add("%"+keyword+"%");
				}
				sql+="and same_catagories.ID not in(select 0 ";
				for (String s : catagoryDetailList) {
					if (!StringUtil.isEmpty(s)) {
						sql += "union "
								+ "select SAME_CATAGORY_ID from same_catagorys_details ,catagory_details "
								+ "where same_catagorys_details.CATAGORY_DETAIL_ID=catagory_details.ID "
								+ "and catagory_details.CATAGORY_ID=(select CATAGORY_ID from catagory_details where ID=?) "
								+ "and CATAGORY_DETAIL_ID!=? ";
						params.add(s);
						params.add(s);
					}
				}
				sql += ")";
				sql+=") as t ";
				if(!StringUtil.isBlank(orderPropoty)){
					sql+="order by "+orderPropoty+" "+orderType;
				}
				resultList = baseDAO.findBySQLForVO(sql, ProductVo.class,
						params.toArray(),offset,pageSize);
				totalSize=baseDAO.getTotalSizeForSQL(sql, params.toArray());
			}
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		map.put("list", resultList);
		map.put("totalSize", totalSize);
		return map;
	}

	@Override
	public int addProduct(ProductVo vo) throws ServiceException {
		// TODO Auto-generated method stub
		Products products;
		int count=0;
		if(StringUtil.isEmpty(vo.getId())){
			SameCatagories sameCatagory=baseDAO.findById(Long.parseLong(vo.getSameCatagory()), SameCatagories.class);
			if(StringUtil.isBlank(vo.getSpecification())){
				count=baseDAO.getTotalSize("from Products where sameCatagories.id=?", 
					new Object[]{sameCatagory.getId()});
				if(count>0){
					return 3;
				}
			}else{
				count=baseDAO.getTotalSize("from Products where sameCatagories.id=? and (specification=? or specification is null)", 
						new Object[]{sameCatagory.getId(),""});
				if(count>0){
					return 4;
				}
			}
			products=new Products();
			products.setCode(vo.getCode());
			products.setMachineCode(vo.getMachineCode());
			if(StringUtil.isEmpty(vo.getSameCatagory())){
				return 1;
			}
			count=baseDAO.getTotalSize("from Products where sameCatagories.id=? and specification=?", 
					new Object[]{sameCatagory.getId(),vo.getSpecification()});
			if(count>0){
				return 2;
			}
			products.setSameCatagories(sameCatagory);
			products.setCrtTm(DateUtil.getCurrentTime());
			//products.setCrtUsr(crtUsr);
		}else{
			products=baseDAO.findById(Long.parseLong(vo.getId()), Products.class);
			if(StringUtil.isBlank(vo.getSpecification())&&!StringUtil.isBlank(products.getSpecification())){
				count=baseDAO.getTotalSize("from Products where sameCatagories.id=? and id!=?", 
					new Object[]{products.getSameCatagories().getId(),products.getId()});
				if(count>0){
					return 3;
				}
			}
			count=baseDAO.getTotalSize("from Products where sameCatagories.id=? and specification=? and specification!=?", 
					new Object[]{products.getSameCatagories().getId(),vo.getSpecification(),products.getSpecification()});
			if(count>0){
				return 2;
			}
		}
		products.setApprovalNumber(vo.getApprovalNumber());
		products.setApprovalNumberValidDate(DateUtil.getDate(vo.getApprovalNumberValidDate()));
		products.setCodeName(vo.getCodeName());
		//products.setMachineCode();
		//products.setMaterialId(materialId);
		//products.setName(vo.getName());
		products.setProductUnit(vo.getProductUnit());
		products.setSpecialManageType(Integer.parseInt(vo.getSpecialManageType()));
		products.setSpecification(vo.getSpecification());
		if(isNeedCheck()){
			products.setStatus(STATUS.AUDITING);
		}else{
			products.setStatus(STATUS.ENABLE);
		}
		products.setStorageCondition(vo.getStorageCondition());
		products.setSupervisonCode(vo.getSupervisonCode());
		if(!StringUtil.isEmpty(vo.getMaterialId())){
			Materials material=baseDAO.findById(Long.parseLong(vo.getMaterialId()), Materials.class);
			products.setMaterials(material);
		}
		if(!StringUtil.isEmpty(vo.getPreUnitCnvrsnFctr())){
			products.setPreUnitCnvrsnFctr(vo.getPreUnitCnvrsnFctr());
		}
		if(!StringUtil.isEmpty(vo.getUnitCnvrsnFctr())){
			products.setUnitCnvrsnFctr(vo.getUnitCnvrsnFctr());
		}
		if(!StringUtil.isBlank(vo.getBaseQuantityUnit())){
			Units unit=baseDAO.findById(Long.parseLong(vo.getBaseQuantityUnit()), Units.class);
			products.setUnitsByBaseQuantityUnitId(unit);
		}
		if(!StringUtil.isBlank(vo.getQuantityUnit1())){
			Units unit=baseDAO.findById(Long.parseLong(vo.getQuantityUnit1()), Units.class);
			products.setUnitsByQuantityUnitId1(unit);
		}
		if(!StringUtil.isBlank(vo.getQuantityUnit2())){
			Units unit=baseDAO.findById(Long.parseLong(vo.getQuantityUnit2()), Units.class);
			products.setUnitsByQuantityUnitId2(unit);
		}
		products.setUpdTm(DateUtil.getCurrentTime());
		products.setCheckTm(DateUtil.getCurrentTime());
		products.setUpdUsr(vo.getUsrId());
		products.setUsedName(vo.getUsedName());
		products.setUserDefinedCode(vo.getUserDefinedCode());
		if(!StringUtil.isEmpty(vo.getValidityPeriod())){
			products.setValidityPeriod(Integer.parseInt(vo.getValidityPeriod()));
		}
		if(!StringUtil.isEmpty(vo.getWarmingDay())){
			products.setWarmingDay(Integer.parseInt(vo.getWarmingDay()));
		}
		products.setCheckUsr(null);
		
		//插入产品历史表
		ProductsHsty productsHsty=new ProductsHsty();
		try {
			BeanUtils.copyProperties(productsHsty,products);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(StringUtil.isEmpty(vo.getId())){
			products.setCrtTm(DateUtil.getCurrentTime());
			products.setCrtUsr(vo.getUsrId());
			products.setCheckTm(null);
			baseDAO.save(products);
		}else{
			baseDAO.update(products);
		}
		productsHsty.setProducts(products);
		productsHsty.setName(products.getSameCatagories().getName()+products.getSpecification());
		productsHsty.setSameCatagorieName(products.getSameCatagories().getName());
		productsHsty.setSameCatagorieCd(products.getSameCatagories().getCatagoryCode()+products.getSameCatagories().getCode());
		productsHsty.setCode(productsHsty.getSameCatagorieCd()+products.getCode());
		if(products.getMaterials()!=null){
			productsHsty.setMaterialName(products.getMaterials().getName());
		}
		if(products.getUnitsByQuantityUnitId1()!=null){
			productsHsty.setQuantityUnitName1(products.getUnitsByQuantityUnitId1().getName());
		}
		if(products.getUnitsByQuantityUnitId2()!=null){
			productsHsty.setQuantityUnitName2(products.getUnitsByQuantityUnitId2().getName());
		}
		if(products.getUnitsByBaseQuantityUnitId()!=null){
			productsHsty.setBaseQuantityUnitName(products.getUnitsByBaseQuantityUnitId().getName());
		}
		productsHsty.setCrtTm(DateUtil.getCurrentTime());
		productsHsty.setCheckTm(null);
		baseDAO.save(productsHsty);
		return 0;
	}

	@Override
	public int deleteProduct(String id) throws ServiceException {
		// TODO Auto-generated method stub
		if(!StringUtil.isEmpty(id)){
			Products products=baseDAO.findById(Long.parseLong(id),Products.class);
			baseDAO.delete(products);
		}
		return 0;
	}

	@Override
	public ProductVo getProduct(String id) throws ServiceException {
		// TODO Auto-generated method stub
		if(!StringUtil.isEmpty(id)){
			Products products=baseDAO.findById(Long.parseLong(id), Products.class);
			ProductVo vo=new ProductVo();
			vo.setId(StringUtil.objToString(products.getId()));
			vo.setApprovalNumber(products.getApprovalNumber());
			vo.setApprovalNumberValidDate(DateUtil.getDateString(products.getApprovalNumberValidDate()));
			vo.setCodeName(products.getCodeName());
			vo.setMachineCode(products.getMachineCode());
			//vo.setMaterial(material);
			vo.setName(products.getSameCatagories().getName()+" "+products.getSpecification());
			vo.setProductUnit(products.getProductUnit());
			vo.setSameCatagoryName(products.getSameCatagories().getName());
			vo.setSameCatagoryCode(products.getSameCatagories().getCatagoryCode()+products.getSameCatagories().getCode());
			vo.setCatagoryCode(products.getSameCatagories().getCatagoryCode()+products.getSameCatagories().getCode()+products.getCode());
			vo.setSpecialManageType(StringUtil.objToString(products.getSpecialManageType()));
			vo.setSpecification(products.getSpecification());
			vo.setStorageCondition(products.getStorageCondition());
			vo.setSupervisonCode(products.getSupervisonCode());
			vo.setUnitCnvrsnFctr(StringUtil.objToString(products.getUnitCnvrsnFctr()));
			vo.setPreUnitCnvrsnFctr(StringUtil.objToString(products.getPreUnitCnvrsnFctr()));
			if(products.getMaterials()!=null){
				vo.setMaterialId(products.getMaterials().getId()+"");
				vo.setMaterialName(products.getMaterials().getName());
			}
			if(products.getUnitsByBaseQuantityUnitId()!=null){
				vo.setBaseQuantityUnit(products.getUnitsByBaseQuantityUnitId().getId()+"");
			}
			if(products.getUnitsByQuantityUnitId1()!=null){
				vo.setQuantityUnit1(products.getUnitsByQuantityUnitId1().getId()+"");
			}
			if(products.getUnitsByQuantityUnitId2()!=null){
				vo.setQuantityUnit2(products.getUnitsByQuantityUnitId2().getId()+"");
			}
			vo.setUsedName(products.getUsedName());
			vo.setUserDefinedCode(products.getUserDefinedCode());
			vo.setValidityPeriod(StringUtil.objToString(products.getValidityPeriod()));
			vo.setWarmingDay(StringUtil.objToString(products.getWarmingDay()));
			return vo;
		}
		return null;
	}

	@Override
	public int isAbleAddProduct(String sameCatagoryId) throws ServiceException {
		// TODO Auto-generated method stub
		int count=baseDAO.getTotalSize("from Products where sameCatagories.id=? and (specification=? or specification is null)", 
				new Object[]{Long.parseLong(sameCatagoryId),""});
		if(count>0){
			return 1;
		}
		return 0;
	}

	@Override
	public int checkProduct(String productId,String userId) throws ServiceException {
		// TODO Auto-generated method stub
		Products products=baseDAO.findById(Long.parseLong(productId),Products.class);
		if(userId.equals(products.getUpdUsr())){
			return 1;
		}
		products.setStatus(0);
		products.setCheckUsr(userId);
		products.setCheckTm(DateUtil.getCurrentTime());
		baseDAO.update(products);
		
		//更新历史表
		List<ProductsHsty> list=baseDAO.findByHQL("from ProductsHsty where products.id=? order by crtTm desc",new Object[]{Long.parseLong(productId)});
		if(list.size()>0){
			ProductsHsty ph=list.get(0);
			ph.setStatus(0);
			ph.setCheckUsr(userId);
			ph.setCheckTm(DateUtil.getCurrentTime());
			baseDAO.update(ph);
		}
		return 0;
	}

	private boolean isNeedCheck(){
		String s=sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.IS_PRODUCT_EDIT_CHECK);
		if("1".equals(s)){
			return true;
		}
		return false;
	}
	
	public ProductVo getProductHsty(String id) throws ServiceException {
		// TODO Auto-generated method stub
		if(!StringUtil.isEmpty(id)){
			ProductsHsty productHsty=baseDAO.findById(Long.parseLong(id), ProductsHsty.class);
			ProductVo vo=new ProductVo();
			vo.setApprovalNumber(productHsty.getApprovalNumber());
			vo.setApprovalNumberValidDate(DateUtil.getDateString(productHsty.getApprovalNumberValidDate()));
			vo.setCodeName(productHsty.getCodeName());
			vo.setMachineCode(productHsty.getMachineCode());
			//vo.setMaterial(material);
			vo.setName(productHsty.getName());
			vo.setProductUnit(productHsty.getProductUnit());
			vo.setSameCatagoryName(productHsty.getSameCatagorieName());
			vo.setSameCatagoryCode(productHsty.getSameCatagorieCd());
			vo.setCatagoryCode(productHsty.getCode());
			vo.setSpecialManageType(StringUtil.objToString(productHsty.getSpecialManageType()));
			vo.setSpecification(productHsty.getSpecification());
			vo.setStorageCondition(productHsty.getStorageCondition());
			vo.setSupervisonCode(productHsty.getSupervisonCode());
			vo.setUnitCnvrsnFctr(StringUtil.objToString(productHsty.getUnitCnvrsnFctr()));
			vo.setPreUnitCnvrsnFctr(StringUtil.objToString(productHsty.getPreUnitCnvrsnFctr()));
			vo.setMaterialName(productHsty.getMaterialName());
			vo.setBaseQuantityUnit(productHsty.getBaseQuantityUnitName());
			vo.setQuantityUnit1(productHsty.getQuantityUnitName1());
			vo.setQuantityUnit2(productHsty.getQuantityUnitName2());
			vo.setUsedName(productHsty.getUsedName());
			vo.setUserDefinedCode(productHsty.getUserDefinedCode());
			vo.setValidityPeriod(StringUtil.objToString(productHsty.getValidityPeriod()));
			vo.setWarmingDay(StringUtil.objToString(productHsty.getWarmingDay()));
			return vo;
		}
		return null;
	}
}
