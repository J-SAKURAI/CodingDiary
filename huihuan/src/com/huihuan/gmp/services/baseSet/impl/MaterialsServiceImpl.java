package com.huihuan.gmp.services.baseSet.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.huihuan.common.util.DateUtil;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.STATUS;
import com.huihuan.gmp.cst.SYS_PROPERTY;
import com.huihuan.gmp.daos.baseSet.SysPropotyDao;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.Const;
import com.huihuan.gmp.entity.MaterialsHsty;
import com.huihuan.gmp.entity.Products;
import com.huihuan.gmp.entity.MaterialCatagoryDetails;
import com.huihuan.gmp.entity.Materials;
import com.huihuan.gmp.entity.ProductsHsty;
import com.huihuan.gmp.entity.Units;
import com.huihuan.gmp.entity.Wrappers;
import com.huihuan.gmp.services.baseSet.IMaterialsService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.vo.MaterialVo;
import com.huihuan.gmp.vo.ProductVo;
import com.huihuan.gmp.vo.SameCatagoryVo;

@Service(value = "materialsService")
public class MaterialsServiceImpl extends CommServiceImpl implements
		IMaterialsService {

	private Log log = LogFactory.getLog(MaterialsServiceImpl.class);

	@Resource
	SysPropotyDao sysPropotyDao;

	@Override
	public List<Materials> getMaterialDetails() throws ServiceException {
		// TODO Auto-generated method stub
		List<Materials> list = baseDAO.findByHQL("from Materials",
				new Object[] {});
		return list;
	}

	// @Override
	// public List<Materials> getMaterialDetails1(String Id, String state,
	// String kw)
	// throws ServiceException {
	// // TODO Auto-generated method stub
	// List<Materials> list = baseDAO.findByHQL("from Catagories where type=?",
	// new Object[]{type});
	// return list;
	// }
	//
	// @Override
	// public List<Materials> getMaterialDetails(String Id)
	// throws ServiceException {
	// // TODO Auto-generated method stub
	// List<Materials> list = baseDAO.findByHQL("from Materials",
	// new Object[]{Id});
	// return list;

	@Override
	public int addMaterialDetail(String catagoryId, String name,String quantityUnit1,String quantityUnit2,
			String catagoryCode, String code, String isMiddle,
			String productId, String userDefinedCode, String usedName,String preUnitCnvrsnFctr,
			String unitCnvrsnFctr,
			String baseQuantityUnit, String isRepeatWeight,
			String toleranceRange, String repeatWeightFormula,
			String supplementFormula, String specialManageType,
			String minInventory, String maxInventory, String storageCondition,
			String warmingDay, String status,String validityPeriod,
			String photoUrl,String validityManageType,String machineCode,String userId) throws ServiceException {

		
		
		ObjectMapper mapper = new ObjectMapper();
		List<String> catagoryDetailList = new ArrayList<String>();
		try {
			catagoryDetailList = mapper.readValue(catagoryId, List.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Materials> list = baseDAO.findByHQL(
				"from Materials where name=? and catagoryCode=?", new Object[] {
						name, catagoryCode});

		if (list.size() > 0) {
			return 1;
		}

		List<Materials> list1 = baseDAO.findByHQL(
				"from Materials where catagoryCode=? and code=?", new Object[] {
						catagoryCode, code });
		if (list1.size() > 0) {
			return 2;
		}
		
		

		List<Materials> list2=baseDAO.findByHQL("from Materials where userDefinedCode=?", 
				new Object[] {userDefinedCode});
		if(list2.size() > 0)
			return 3;

		Materials materials = new Materials();
		materials.setName(name);
		if ((catagoryCode!=null)&&(!catagoryCode.isEmpty())) {
			materials.setCatagoryCode(catagoryCode);
		}
		if((code!=null)&&(!code.isEmpty())){
			materials.setCode(code);
		}

		if ((isMiddle!=null)&&(!isMiddle.isEmpty())) {
			Integer ismiddle = Integer.parseInt(isMiddle);
			materials.setIsMiddle(ismiddle);
		}
		if ((userDefinedCode!=null)&&(!userDefinedCode.isEmpty())) {
			materials.setUserDefinedCode(userDefinedCode);
		}
		if ((usedName!=null)&&(!usedName.isEmpty())) {
			materials.setUsedName(usedName);
		}
		//materials.setQuantityUnit(quantityUnit);
		
		if((baseQuantityUnit!=null)&&(!baseQuantityUnit.isEmpty())){
			Units unit=baseDAO.findById(Long.parseLong(baseQuantityUnit), Units.class);
			materials.setUnitsByBaseQuantityUnitId(unit);
		}
		if((quantityUnit1!=null)&&(!quantityUnit1.isEmpty())){
			Units unit=baseDAO.findById(Long.parseLong(quantityUnit1), Units.class);
			materials.setUnitsByQuantityUnitId1(unit);
		}
		if((quantityUnit2!=null)&&(!quantityUnit2.isEmpty())){
			Units unit=baseDAO.findById(Long.parseLong(quantityUnit2), Units.class);
			materials.setUnitsByQuantityUnitId2(unit);
		}
		
		
		if(!StringUtil.isEmpty(preUnitCnvrsnFctr)){
			materials.setPreUnitCnvrsnFctr(preUnitCnvrsnFctr);
		}
		
		
		if ((unitCnvrsnFctr!=null)&&(!unitCnvrsnFctr.isEmpty())) {
			materials.setUnitCnvrsnFctr(unitCnvrsnFctr);
		}
//		if ((baseQuantityUnit!=null)&&(!baseQuantityUnit.isEmpty())) {
//			materials.setBaseQuantityUnit(baseQuantityUnit);
//		}

		if ((isRepeatWeight!=null)&&(!isRepeatWeight.isEmpty())) {
			Integer isRepeatWeight1 = Integer.parseInt(isRepeatWeight);
			materials.setIsRepeatWeight(isRepeatWeight1);
		}
		if ((toleranceRange!=null)&&(!toleranceRange.isEmpty())) {
			Float toleranceRange1 = Float.parseFloat(toleranceRange);
			materials.setToleranceRange(toleranceRange1);
		}
		if ((repeatWeightFormula!=null)&&(!repeatWeightFormula.isEmpty())) {
			materials.setRepeatWeightFormula(repeatWeightFormula);
		}
		if ((supplementFormula!=null)&&(!supplementFormula.isEmpty())) {
			materials.setSupplementFormula(supplementFormula);
		}
		if ((specialManageType!=null)&&(!specialManageType.isEmpty())) {
			Integer specialManageType1 = Integer.parseInt(specialManageType);
			materials.setSpecialManageType(specialManageType1);
		}
		if ((minInventory!=null)&&(!minInventory.isEmpty())) {
			Float minInventory1 = Float.parseFloat(minInventory);
			materials.setMinInventory(minInventory1);
		}
		if ((maxInventory!=null)&&(!maxInventory.isEmpty())) {
			Float maxInventory1 = Float.parseFloat(maxInventory);
			materials.setMaxInventory(maxInventory1);
		}
		if ((storageCondition!=null)&&(!storageCondition.isEmpty())) {
			materials.setStorageCondition(storageCondition);
		}
		if ((warmingDay!=null)&&(!warmingDay.isEmpty())) {
			Integer warmingDay1=Integer.parseInt(warmingDay);
			materials.setWarmingDay(warmingDay1);
		}
		if((validityPeriod!=null)&&(!validityPeriod.isEmpty())){
			Integer validityPeriod1=Integer.parseInt(validityPeriod);
			materials.setValidityPeriod(validityPeriod1);
		}
		
		if((photoUrl!=null)&&(!photoUrl.isEmpty())){
			materials.setPhotoUrl(photoUrl);
		}
		
		if((validityManageType!=null)&&(!validityManageType.isEmpty())){
			Integer validityManageType1=Integer.parseInt(validityManageType);
			materials.setValidityManageType(validityManageType1);
		}
//		Integer status1 = Integer.parseInt("1");
//		materials.setStatus(status1);

		materials.setMachineCode(machineCode);
		if(isNeedCheck()){
			materials.setStatus(STATUS.AUDITING);
		}else{
			materials.setStatus(STATUS.ENABLE);
		}
		materials.setCrtTm(DateUtil.getCurrentTime());
		materials.setCrtUsr(userId);
		materials.setUpdTm(DateUtil.getCurrentTime());
		materials.setUpdUsr(userId);
		baseDAO.save(materials);
		
		List params = new ArrayList();
		for (String s : catagoryDetailList) {
			if (!StringUtil.isEmpty(s)) {
				Long catagoryid=Long.parseLong(s);
				CatagoryDetails catagoryDetail1 = baseDAO.findById(catagoryid, CatagoryDetails.class);
				MaterialCatagoryDetails materialCatagoryDetails = new MaterialCatagoryDetails();
				materialCatagoryDetails.setMaterials(materials);
				materialCatagoryDetails.setCatagoryDetails(catagoryDetail1);
				baseDAO.save(materialCatagoryDetails);
				
				}
			}
		//插入历史表
		MaterialsHsty materialsHsty=new MaterialsHsty();
		materialsHsty.setMaterials(materials);
		materialsHsty.setName(materials.getName());
		materialsHsty.setCatagoryCode(materials.getCatagoryCode());
		materialsHsty.setCode(materials.getCatagoryCode()+materials.getCode());
		materialsHsty.setMachineCode(materials.getMachineCode());
		materialsHsty.setUserDefinedCode(materials.getUserDefinedCode());
		materialsHsty.setUsedName(materials.getUsedName());
		materialsHsty.setPreUnitCnvrsnFctr(materials.getPreUnitCnvrsnFctr());
		if(materials.getUnitsByQuantityUnitId1()!=null)
			materialsHsty.setQuantityUnitName1(materials.getUnitsByQuantityUnitId1().getName());
		if(materials.getUnitsByQuantityUnitId2()!=null)
			materialsHsty.setQuantityUnitName2(materials.getUnitsByQuantityUnitId2().getName());
		materialsHsty.setUnitCnvrsnFctr(materials.getUnitCnvrsnFctr());
		if(materials.getUnitsByBaseQuantityUnitId()!=null)
			materialsHsty.setQuantityUnitName2(materials.getUnitsByBaseQuantityUnitId().getName());
		materialsHsty.setSpecialManageType(materials.getSpecialManageType());
		materialsHsty.setStorageCondition(materials.getStorageCondition());
		materialsHsty.setValidityManageType(materials.getValidityManageType());
		materialsHsty.setPhotoUrl(materials.getPhotoUrl());
		materialsHsty.setValidityPeriod(materials.getValidityPeriod());
		materialsHsty.setWarmingDay(materials.getWarmingDay());
		materialsHsty.setStatus(materials.getStatus());
		materialsHsty.setCrtTm(DateUtil.getCurrentTime());
		materialsHsty.setCrtUsr(materials.getCrtUsr());
		materialsHsty.setUpdTm(materials.getUpdTm());
		materialsHsty.setUpdUsr(materials.getUpdUsr());
		baseDAO.save(materialsHsty);
		return 0;

	}

	@Override
	public int deleteMaterialDetail(String Id) throws ServiceException {
		if(!StringUtil.isEmpty(Id)){
			
			List<MaterialCatagoryDetails> list = baseDAO.findByHQL(
					"from MaterialCatagoryDetails where materials.id=?",new Object[] {Long.parseLong(Id)});
			for(MaterialCatagoryDetails materialCatagoryDetails:list){
				baseDAO.delete(materialCatagoryDetails);
			}

			Materials materials = baseDAO.findById(Long.parseLong(Id), Materials.class);
			baseDAO.delete(materials);
		}
		
		return 0;

	}

	@Override
	public Materials getMaterialsDetails(Long Id) throws ServiceException {

		Materials materials = baseDAO.findById(Id, Materials.class);
		return materials;

	}

	@Override
	public MaterialsHsty getMaterialsHstyDetails(Long Id) throws ServiceException {

		MaterialsHsty materialHsty = baseDAO.findById(Id, MaterialsHsty.class);
		return materialHsty;

	}

	@Override
	public List<MaterialCatagoryDetails> getMaterialCatagoryDetail(Long Id) {
		List<MaterialCatagoryDetails> list = baseDAO.findByHQL(
				"from MaterialCatagoryDetails where materials.id=?",
				new Object[] { Id });
		return list;
	}

	@Override
	public Map getMaterials(String catagoryDetails, String queryPage,
			String size, String keyword, String status,String orderPropoty,String orderType) {
		// // TODO Auto-generated method stub
		Map map = new HashMap();
		int totalSize = 0;
		List resultList = new ArrayList();
		int offset = -1;
		int pageSize = 1;
		if (!StringUtil.isEmpty(size)) {
			pageSize = Integer.parseInt(size);
		}
		if (!StringUtil.isEmpty(queryPage)) {
			offset = (Integer.parseInt(queryPage) - 1) * pageSize;
		}

		ObjectMapper mapper = new ObjectMapper();

		// mapper.enableDefaultTyping();

		List<String> catagoryDetailList = new ArrayList<String>();
		try {
			catagoryDetailList = mapper.readValue(catagoryDetails, List.class);
			String sql="select t.id as id," +
					"t.code as code," +
					"t.name as name," +
					"t.quantityUnit1 as quantityUnit1," +
					"t.specialManageType as specialManageType," +
					"t.status as status " +
					"from (";
			sql += "select DISTINCT "
					+ "materials.id as id,"
					+ "CONCAT(materials.catagory_code,materials.code) as code,"
					+ "materials.name as name,"
					+ "units.name as quantityUnit1,"
					+ "materials.SPECIAL_MANAGE_TYPE as specialManageType,"
					+ "materials.status as status "
					+ "from materials "
					+ "left join units on materials.QUANTITY_UNIT_ID1=units.id "
					+ "left join material_catagory_details on material_catagory_details.MATERIAL_ID=materials.ID "
					+ "where materials.ID "
					+ "not in(select 0 ";
			List params = new ArrayList();
			for (String s : catagoryDetailList) {
				if (!StringUtil.isEmpty(s)) {
					sql += "union "
							+ "select MATERIAL_ID from material_catagory_details,catagory_details "
							+ "where material_catagory_details.CATAGORY_DETAIL_ID=catagory_details.ID "
							+ "and catagory_details.CATAGORY_ID=(select CATAGORY_ID from catagory_details where ID=?) "
							+ "and CATAGORY_DETAIL_ID!=? ";
					Integer t = Integer.parseInt(s);
					params.add(t);
					params.add(t);
				}
			}

			sql += ")";

			if (!StringUtil.isEmpty(keyword)) {
				sql += " and (materials.code like ? or materials.name like ?)";
				params.add("%" + keyword + "%");
				params.add("%" + keyword + "%");

			}

			if (!StringUtil.isEmpty(status)) {
				sql += " and materials.status = ?";
				Integer s = Integer.parseInt(status);
				params.add(s);

			}
			sql+=") as t ";
			if(!StringUtil.isBlank(orderPropoty)){
				sql+="order by "+orderPropoty+" "+orderType;
			}
			resultList = baseDAO.findBySQLForVO(sql, MaterialVo.class,
					params.toArray(), offset, pageSize);
			totalSize = baseDAO.getTotalSizeForSQL(sql, params.toArray());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.put("list", resultList);
		map.put("totalSize", totalSize);

		return map;
	}

	@Override
	public int updateMaterialDetail(String Id, String name,String quantityUnit1,String quantityUnit2,
			String catagoryCode, String code, String isMiddle,
			String productId, String userDefinedCode, String usedName,
			String preUnitCnvrsnFctr,String unitCnvrsnFctr,
			String baseQuantityUnit, String isRepeatWeight,
			String toleranceRange, String repeatWeightFormula,
			String supplementFormula, String specialManageType,
			String minInventory, String maxInventory, String storageCondition,
			String warmingDay, String status,String validityPeriod,String photoUrl,String validityManageType,String userId) throws ServiceException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(Id);
		Materials materials = baseDAO.findById(id, Materials.class);
		materials.setName(name);
		if ((catagoryCode!=null)&&(!catagoryCode.isEmpty())) {
			materials.setCatagoryCode(catagoryCode);
		}
		if((code!=null)&&(!code.isEmpty())){
			materials.setCode(code);
		}

		if ((isMiddle!=null)&&(!isMiddle.isEmpty())) {
			Integer ismiddle = Integer.parseInt(isMiddle);
			materials.setIsMiddle(ismiddle);
		}
		if ((userDefinedCode!=null)&&(!userDefinedCode.isEmpty())) {
			materials.setUserDefinedCode(userDefinedCode);
		}
		if ((usedName!=null)&&(!usedName.isEmpty())) {
			materials.setUsedName(usedName);
		}
//		materials.setQuantityUnit(quantityUnit);
		if ((unitCnvrsnFctr!=null)&&(!unitCnvrsnFctr.isEmpty())) {
			materials.setUnitCnvrsnFctr(unitCnvrsnFctr);
		}
//		if ((baseQuantityUnit!=null)&&(!baseQuantityUnit.isEmpty())) {
//			materials.setBaseQuantityUnit(baseQuantityUnit);
//		}
		if((preUnitCnvrsnFctr!=null)&&(!preUnitCnvrsnFctr.isEmpty())){
			materials.setPreUnitCnvrsnFctr(preUnitCnvrsnFctr);
		}
		
		if((baseQuantityUnit!=null)&&(!baseQuantityUnit.isEmpty())){
			Units unit=baseDAO.findById(Long.parseLong(baseQuantityUnit), Units.class);
			materials.setUnitsByBaseQuantityUnitId(unit);
		}
		if((quantityUnit1!=null)&&(!quantityUnit1.isEmpty())){
			Units unit=baseDAO.findById(Long.parseLong(quantityUnit1), Units.class);
			materials.setUnitsByQuantityUnitId1(unit);
		}
		if((quantityUnit2!=null)&&(!quantityUnit2.isEmpty())){
			Units unit=baseDAO.findById(Long.parseLong(quantityUnit2), Units.class);
			materials.setUnitsByQuantityUnitId2(unit);
		}

		if ((isRepeatWeight!=null)&&(!isRepeatWeight.isEmpty())) {
			Integer isRepeatWeight1 = Integer.parseInt(isRepeatWeight);
			materials.setIsRepeatWeight(isRepeatWeight1);
		}
		if ((toleranceRange!=null)&&(!toleranceRange.isEmpty())) {
			Float toleranceRange1 = Float.parseFloat(toleranceRange);
			materials.setToleranceRange(toleranceRange1);
		}
		if ((repeatWeightFormula!=null)&&(!repeatWeightFormula.isEmpty())) {
			materials.setRepeatWeightFormula(repeatWeightFormula);
		}
		if ((supplementFormula!=null)&&(!supplementFormula.isEmpty())) {
			materials.setSupplementFormula(supplementFormula);
		}
		if ((specialManageType!=null)&&(!specialManageType.isEmpty())) {
			Integer specialManageType1 = Integer.parseInt(specialManageType);
			materials.setSpecialManageType(specialManageType1);
		}
		if ((minInventory!=null)&&(!minInventory.isEmpty())) {
			Float minInventory1 = Float.parseFloat(minInventory);
			materials.setMinInventory(minInventory1);
		}
		if ((maxInventory!=null)&&(!maxInventory.isEmpty())) {
			Float maxInventory1 = Float.parseFloat(maxInventory);
			materials.setMaxInventory(maxInventory1);
		}
		if ((storageCondition!=null)&&(!storageCondition.isEmpty())) {
			materials.setStorageCondition(storageCondition);
		}
		if ((warmingDay!=null)&&(!warmingDay.isEmpty())) {
			Integer warmingDay1=Integer.parseInt(warmingDay);
			materials.setWarmingDay(warmingDay1);
		}
		
		if((validityPeriod!=null)&&(!validityPeriod.isEmpty())){
			Integer validityPeriod1=Integer.parseInt(validityPeriod);
			materials.setValidityPeriod(validityPeriod1);
		}
		
		if((photoUrl!=null)&&(!photoUrl.isEmpty())){
			materials.setPhotoUrl(photoUrl);
		}
		
		if((validityManageType!=null)&&(!validityManageType.isEmpty())){
			Integer validityManageType1=Integer.parseInt(validityManageType);
			materials.setValidityManageType(validityManageType1);
		}
		if(isNeedCheck()){
			materials.setStatus(STATUS.AUDITING);
		}else{
			materials.setStatus(STATUS.ENABLE);
		}
		materials.setUpdTm(DateUtil.getCurrentTime());
		materials.setUpdUsr(userId);
		baseDAO.update(materials);
		//插入历史表
		MaterialsHsty materialsHsty=new MaterialsHsty();
		materialsHsty.setMaterials(materials);
		materialsHsty.setName(materials.getName());
		materialsHsty.setCatagoryCode(materials.getCatagoryCode());
		materialsHsty.setCode(materials.getCatagoryCode()+materials.getCode());
		materialsHsty.setMachineCode(materials.getMachineCode());
		materialsHsty.setUserDefinedCode(materials.getUserDefinedCode());
		materialsHsty.setUsedName(materials.getUsedName());
		materialsHsty.setPreUnitCnvrsnFctr(materials.getPreUnitCnvrsnFctr());
		if(materials.getUnitsByQuantityUnitId1()!=null)
			materialsHsty.setQuantityUnitName1(materials.getUnitsByQuantityUnitId1().getName());
		if(materials.getUnitsByQuantityUnitId2()!=null)
			materialsHsty.setQuantityUnitName2(materials.getUnitsByQuantityUnitId2().getName());
		materialsHsty.setUnitCnvrsnFctr(materials.getUnitCnvrsnFctr());
		if(materials.getUnitsByBaseQuantityUnitId()!=null)
			materialsHsty.setQuantityUnitName2(materials.getUnitsByBaseQuantityUnitId().getName());
		materialsHsty.setSpecialManageType(materials.getSpecialManageType());
		materialsHsty.setStorageCondition(materials.getStorageCondition());
		materialsHsty.setValidityManageType(materials.getValidityManageType());
		materialsHsty.setPhotoUrl(materials.getPhotoUrl());
		materialsHsty.setValidityPeriod(materials.getValidityPeriod());
		materialsHsty.setWarmingDay(materials.getWarmingDay());
		materialsHsty.setStatus(materials.getStatus());
		materialsHsty.setCrtTm(DateUtil.getCurrentTime());
		materialsHsty.setCrtUsr(materials.getCrtUsr());
		materialsHsty.setUpdTm(materials.getUpdTm());
		materialsHsty.setUpdUsr(materials.getUpdUsr());
		baseDAO.save(materialsHsty);
		return 0;
	}

	@Override
	public CatagoryDetails getCatagoryDetail(Long catagoryId)
			throws ServiceException {
		// TODO Auto-generated method stub
		CatagoryDetails catagoryDetails = baseDAO.findById(catagoryId, CatagoryDetails.class);
		return catagoryDetails;	
		}
	
	@Override
	public String getProductName(String materialsId) throws ServiceException{
		String productname = "";
		List<Products> list = baseDAO.findByProperty("materials.id", Long.parseLong(materialsId), Products.class);
		if (list.size()>0){
			for(Products p : list){
				productname+=p.getSameCatagories().getName()+" "+p.getSpecification()+",";
			}
			productname=productname.substring(0,productname.length()-1);
		}
		return productname;
	}

	@Override
	public int check(String id, String userId) throws ServiceException {
		// TODO Auto-generated method stub
		Materials materials=baseDAO.findById(Long.parseLong(id),Materials.class);
		if(userId.equals(materials.getUpdUsr())){
			return 1;
		}
		materials.setStatus(0);
		materials.setCheckUsr(userId);
		materials.setCheckTm(DateUtil.getCurrentTime());
		
		baseDAO.update(materials);
		//更新历史表
		List<MaterialsHsty> list=baseDAO.findByHQL("from MaterialsHsty where materials.id=? order by crtTm desc",new Object[]{Long.parseLong(id)});
		if(list.size()>0){
			MaterialsHsty h=list.get(0);
			h.setStatus(0);
			h.setCheckUsr(userId);
			h.setCheckTm(DateUtil.getCurrentTime());
			baseDAO.update(h);
		}
		return 0;
	}

	@Override
	public String getCurrentCode(String catagoryDetails) throws ServiceException {
		// TODO Auto-generated method stub
		String code="0";
		ObjectMapper mapper = new ObjectMapper();
		List<String> catagoryDetailList = new ArrayList<String>();
		try {
			catagoryDetailList = mapper.readValue(catagoryDetails, List.class);
			String sql = "select DISTINCT "
					+ "materials.code as code "
					+ "from materials "
					+ "where materials.ID "
					+ "not in(select 0 ";
			List params = new ArrayList();
			for (String s : catagoryDetailList) {
				if (!StringUtil.isEmpty(s)) {
					sql += "union "
							+ "select MATERIAL_ID from material_catagory_details,catagory_details "
							+ "where material_catagory_details.CATAGORY_DETAIL_ID=catagory_details.ID "
							+ "and catagory_details.CATAGORY_ID=(select CATAGORY_ID from catagory_details where ID=?) "
							+ "and CATAGORY_DETAIL_ID!=? ";
					Integer t = Integer.parseInt(s);
					params.add(t);
					params.add(t);
				}
			}

			sql += ") order by code desc";

			List<String> list = baseDAO.findBySQL(sql , params.toArray());
			if(list.size()>0){
				code=list.get(0);
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return code;
	}

	private boolean isNeedCheck(){
		String s=sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.IS_MATERIAL_EDIT_CHECK);
		if("1".equals(s)){
			return true;
		}
		return false;
	}

}
