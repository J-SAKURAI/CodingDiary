package com.huihuan.gmp.services.baseSet.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.databinding.WrapperHelper;
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
import com.huihuan.gmp.entity.MaterialCatagoryDetails;
import com.huihuan.gmp.entity.MaterialsHsty;
import com.huihuan.gmp.entity.Products;
import com.huihuan.gmp.entity.Units;
import com.huihuan.gmp.entity.WrapperCatagoryDetails;
import com.huihuan.gmp.entity.Wrappers;
import com.huihuan.gmp.entity.WrappersHsty;
import com.huihuan.gmp.services.baseSet.IWrapperService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.vo.MaterialVo;
import com.huihuan.gmp.vo.WrapperVo;

@Service(value = "wrapperService")
public class WrapperServiceImpl extends CommServiceImpl implements
		IWrapperService {
	private Log log = LogFactory.getLog(WrapperServiceImpl.class);

	@Resource
	SysPropotyDao sysPropotyDao;

	@Override
	public int deleteWrapperDetail(String Id) throws ServiceException {

		if (!StringUtil.isEmpty(Id)) {
			List<WrapperCatagoryDetails> list = baseDAO.findByHQL(
					"from WrapperCatagoryDetails where wrappers.id=?",
					new Object[] { Long.parseLong(Id) });
			for (WrapperCatagoryDetails wrapperCatagoryDetails : list) {
				baseDAO.delete(wrapperCatagoryDetails);
			}

			Wrappers wrappers = baseDAO.findById(Long.parseLong(Id),
					Wrappers.class);
			baseDAO.delete(wrappers);
		}

		return 0;
	}

	@Override
	public Wrappers getWrappersDetails(Long Id) throws ServiceException {
		Wrappers wrappers = baseDAO.findById(Id, Wrappers.class);

		return wrappers;

	}

	@Override
	public WrappersHsty getWrappersHstyDetails(Long Id) throws ServiceException {
		WrappersHsty wrappersHsty = baseDAO.findById(Id, WrappersHsty.class);

		return wrappersHsty;

	}

	@Override
	public Map getWrappers(String catagoryDetails, String queryPage,
			String size, String keyword, String status,String orderPropoty,String orderType) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
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
		List<String> catagoryDetailList;
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
					+ "wrappers.id as id,"
					+ "CONCAT(wrappers.catagory_code,wrappers.code) as code,"
					+
					// "wrappers.code as code," +
					"wrappers.name as name,"
					+ "units.name as quantityUnit1,"
					+ "wrappers.SPECIAL_MANAGE_TYPE as specialManageType,"
					+ "wrappers.status as status "
					+ "from wrappers "
					+ "left join units on wrappers.QUANTITY_UNIT_ID1=units.id "
					+

					"left join wrapper_catagory_details on wrapper_catagory_details.WRAPPER_ID=wrappers.ID "
					+ "where wrappers.ID "
					+ "not in(select 0 ";
			List params = new ArrayList();
			for (String s : catagoryDetailList) {
				if (!StringUtil.isEmpty(s)) {
					sql += "union "
							+ "select WRAPPER_ID from wrapper_catagory_details,catagory_details "
							+ "where wrapper_catagory_details.CATAGORY_DETAIL_ID=catagory_details.ID "
							+ "and catagory_details.CATAGORY_ID=(select CATAGORY_ID from catagory_details where ID=?) "
							+ "and CATAGORY_DETAIL_ID!=? ";
					Integer t = Integer.parseInt(s);
					params.add(t);
					params.add(t);
				}
			}
			sql += ")";

			if (!StringUtil.isEmpty(keyword)) {
				sql += " and (wrappers.code like ? or wrappers.name like ?)";
				params.add("%" + keyword + "%");
				params.add("%" + keyword + "%");

			}

			if (!StringUtil.isEmpty(status)) {
				sql += " and wrappers.status = ?";
				Integer s = Integer.parseInt(status);
				params.add(s);

			}
			sql+=") as t ";
			if(!StringUtil.isBlank(orderPropoty)){
				sql+="order by "+orderPropoty+" "+orderType;
			}
			resultList = baseDAO.findBySQLForVO(sql, WrapperVo.class,
					params.toArray(), offset, pageSize);
			totalSize = baseDAO.getTotalSizeForSQL(sql, params.toArray());
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

		map.put("list", resultList);
		map.put("totalSize", totalSize);

		return map;
	}

	@Override
	public int addWrapperDetail(String catagoryId, String name,
			String quantityUnit1, String quantityUnit2, String catagoryCode,
			String code, String userDefinedCode, String usedName,
			String preUnitCnvrsnFctr, String unitCnvrsnFctr,
			String baseQuantityUnit, String isRepeatWeight,
			String toleranceRange, String repeatWeightFormula,
			String specialManageType, String status, String machineCode,String userId)
			throws ServiceException {
		// TODO Auto-generated method stub

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

		List<Wrappers> list = baseDAO.findByHQL(
				"from Wrappers where name=? and catagoryCode=?", new Object[] {
						name, catagoryCode });

		List<Wrappers> list1 = baseDAO.findByHQL(
				"from Wrappers where catagoryCode=? and code=?", new Object[] {
						catagoryCode, code });

		List<Wrappers> list2 = baseDAO.findByHQL(
				"from Wrappers where userDefinedCode=?",
				new Object[] { userDefinedCode });
		if (list.size() > 0) {
			return 1;
		}

		if (list1.size() > 0) {
			return 2;
		}

		if (list2.size() > 0) {
			return 3;
		}

		Wrappers wrappers = new Wrappers();
		wrappers.setName(name);
		if ((catagoryCode != null) && (!catagoryCode.isEmpty())) {
			wrappers.setCatagoryCode(catagoryCode);
		}
		if ((code != null) && (!code.isEmpty())) {
			wrappers.setCode(code);
		}
		if ((userDefinedCode != null) && (!userDefinedCode.isEmpty())) {
			wrappers.setUserDefinedCode(userDefinedCode);
		}

		if ((usedName != null) && (!usedName.isEmpty())) {
			wrappers.setUsedName(usedName);
		}
		// if((quantityUnit!=null)&&(!quantityUnit.isEmpty())){
		// wrappers.setQuantityUnit(quantityUnit);
		// }

		if ((baseQuantityUnit != null) && (!baseQuantityUnit.isEmpty())) {
			Units unit = baseDAO.findById(Long.parseLong(baseQuantityUnit),
					Units.class);
			wrappers.setUnitsByBaseQuantityUnitId(unit);
		}
		if ((quantityUnit1 != null) && (!quantityUnit1.isEmpty())) {
			Units unit = baseDAO.findById(Long.parseLong(quantityUnit1),
					Units.class);
			wrappers.setUnitsByQuantityUnitId1(unit);
		}
		if ((quantityUnit2 != null) && (!quantityUnit2.isEmpty())) {
			Units unit = baseDAO.findById(Long.parseLong(quantityUnit2),
					Units.class);
			wrappers.setUnitsByQuantityUnitId2(unit);
		}

		if (!StringUtil.isEmpty(preUnitCnvrsnFctr)) {
			wrappers.setPreUnitCnvrsnFctr(preUnitCnvrsnFctr);
		}

		if ((unitCnvrsnFctr != null) && (!unitCnvrsnFctr.isEmpty())) {
			wrappers.setUnitCnvrsnFctr(unitCnvrsnFctr);
		}
		// if((baseQuantityUnit!=null)&&(!baseQuantityUnit.isEmpty())){
		// wrappers.setBaseQuantityUnit(baseQuantityUnit);
		// }
		if ((isRepeatWeight != null) && (!isRepeatWeight.isEmpty())) {
			Integer isRepeatWight1 = Integer.parseInt(isRepeatWeight);
			wrappers.setIsRepeatWeight(isRepeatWight1);
		}
		if ((toleranceRange != null) && (!toleranceRange.isEmpty())) {
			Float toleranceRange1 = Float.parseFloat(toleranceRange);
			wrappers.setToleranceRange(toleranceRange1);

		}

		if ((repeatWeightFormula != null) && (!repeatWeightFormula.isEmpty())) {
			wrappers.setRepeatWeightFormula(repeatWeightFormula);
		}

		if ((specialManageType != null) && (!specialManageType.isEmpty())) {
			Integer specialManageType1 = Integer.parseInt(specialManageType);
			wrappers.setSpecialManageType(specialManageType1);
		}
		wrappers.setMachineCode(machineCode);
		if(isNeedCheck()){
			wrappers.setStatus(STATUS.AUDITING);
		}else{
			wrappers.setStatus(STATUS.ENABLE);
		}
		wrappers.setCrtTm(DateUtil.getCurrentTime());
		wrappers.setUpdTm(DateUtil.getCurrentTime());
		wrappers.setUpdUsr(userId);
		baseDAO.save(wrappers);

		List params = new ArrayList();
		for (String s : catagoryDetailList) {
			if (!StringUtil.isEmpty(s)) {
				Long catagoryid = Long.parseLong(s);
				CatagoryDetails catagoryDetail1 = baseDAO.findById(catagoryid,
						CatagoryDetails.class);
				WrapperCatagoryDetails wrapperCatagoryDetails = new WrapperCatagoryDetails();
				wrapperCatagoryDetails.setWrappers(wrappers);
				wrapperCatagoryDetails.setCatagoryDetails(catagoryDetail1);
				baseDAO.save(wrapperCatagoryDetails);

			}
		}
		//插入历史表
		WrappersHsty wrappersHsty=new WrappersHsty();
		wrappersHsty.setWrappers(wrappers);
		wrappersHsty.setName(wrappers.getName());
		wrappersHsty.setCode(wrappers.getCatagoryCode()+wrappers.getCode());
		wrappersHsty.setMachineCode(wrappers.getMachineCode());
		wrappersHsty.setUserDefinedCode(wrappers.getUserDefinedCode());
		wrappersHsty.setUsedName(wrappers.getUsedName());
		wrappersHsty.setPreUnitCnvrsnFctr(wrappers.getPreUnitCnvrsnFctr());
		if(wrappers.getUnitsByQuantityUnitId1()!=null)
			wrappersHsty.setQuantityUnitName1(wrappers.getUnitsByQuantityUnitId1().getName());
		if(wrappers.getUnitsByQuantityUnitId2()!=null)
			wrappersHsty.setQuantityUnitName2(wrappers.getUnitsByQuantityUnitId2().getName());
		wrappersHsty.setUnitCnvrsnFctr(wrappers.getUnitCnvrsnFctr());
		if(wrappers.getUnitsByBaseQuantityUnitId()!=null)
			wrappersHsty.setQuantityUnitName2(wrappers.getUnitsByBaseQuantityUnitId().getName());
		wrappersHsty.setSpecialManageType(wrappers.getSpecialManageType());
		wrappersHsty.setStatus(wrappers.getStatus());
		wrappersHsty.setCrtTm(DateUtil.getCurrentTime());
		wrappersHsty.setCrtUsr(wrappers.getCrtUsr());
		wrappersHsty.setUpdTm(wrappers.getUpdTm());
		wrappersHsty.setUpdUsr(wrappers.getUpdUsr());
		baseDAO.save(wrappersHsty);
		return 0;
	}

	@Override
	public int updateWrapperDetail(String Id, String name,
			String quantityUnit1, String quantityUnit2, String catagoryCode,
			String code, String userDefinedCode, String usedName,
			String preUnitCnvrsnFctr, String unitCnvrsnFctr,
			String baseQuantityUnit, String isRepeatWeight,
			String toleranceRange, String repeatWeightFormula,
			String specialManageType, String status,String userId) throws ServiceException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(Id);
		Wrappers wrappers = baseDAO.findById(id, Wrappers.class);
		wrappers.setName(name);
		if ((catagoryCode != null) && (!catagoryCode.isEmpty())) {
			wrappers.setCatagoryCode(catagoryCode);
		}
		if ((code != null) && (!code.isEmpty())) {
			wrappers.setCode(code);
		}
		if ((userDefinedCode != null) && (!userDefinedCode.isEmpty())) {
			wrappers.setUserDefinedCode(userDefinedCode);
		}
		if ((usedName != null) && (!usedName.isEmpty())) {
			wrappers.setUsedName(usedName);
		}
		// if((quantityUnit!=null)&&(!quantityUnit.isEmpty())){
		// wrappers.setQuantityUnit(quantityUnit);
		// }

		if ((baseQuantityUnit != null) && (!baseQuantityUnit.isEmpty())) {
			Units unit = baseDAO.findById(Long.parseLong(baseQuantityUnit),
					Units.class);
			wrappers.setUnitsByBaseQuantityUnitId(unit);
		}
		if ((quantityUnit1 != null) && (!quantityUnit1.isEmpty())) {
			Units unit = baseDAO.findById(Long.parseLong(quantityUnit1),
					Units.class);
			wrappers.setUnitsByQuantityUnitId1(unit);
		}
		if ((quantityUnit2 != null) && (!quantityUnit2.isEmpty())) {
			Units unit = baseDAO.findById(Long.parseLong(quantityUnit2),
					Units.class);
			wrappers.setUnitsByQuantityUnitId2(unit);
		}

		if (!StringUtil.isEmpty(preUnitCnvrsnFctr)) {
			wrappers.setPreUnitCnvrsnFctr(preUnitCnvrsnFctr);
		}

		if ((unitCnvrsnFctr != null) && (!unitCnvrsnFctr.isEmpty())) {
			wrappers.setUnitCnvrsnFctr(unitCnvrsnFctr);
		}
		// if((baseQuantityUnit!=null)&&(!baseQuantityUnit.isEmpty())){
		// wrappers.setBaseQuantityUnit(baseQuantityUnit);
		// }
		if ((isRepeatWeight != null) && (!isRepeatWeight.isEmpty())) {
			Integer isRepeatWight1 = Integer.parseInt(isRepeatWeight);
			wrappers.setIsRepeatWeight(isRepeatWight1);
		}
		if ((toleranceRange != null) && (!toleranceRange.isEmpty())) {
			Float toleranceRange1 = Float.parseFloat(toleranceRange);
			wrappers.setToleranceRange(toleranceRange1);

		}

		if ((repeatWeightFormula != null) && (!repeatWeightFormula.isEmpty())) {
			wrappers.setRepeatWeightFormula(repeatWeightFormula);
		}

		if ((specialManageType != null) && (!specialManageType.isEmpty())) {
			Integer specialManageType1 = Integer.parseInt(specialManageType);
			wrappers.setSpecialManageType(specialManageType1);
		}
		if ((status != null) && (!status.isEmpty())) {
			Integer status1 = Integer.parseInt(status);
			wrappers.setStatus(status1);
		}
		if(isNeedCheck()){
			wrappers.setStatus(STATUS.AUDITING);
		}else{
			wrappers.setStatus(STATUS.ENABLE);
		}
		wrappers.setUpdTm(DateUtil.getCurrentTime());
		wrappers.setUpdUsr(userId);
		baseDAO.update(wrappers);

		//插入历史表
		WrappersHsty wrappersHsty=new WrappersHsty();
		wrappersHsty.setWrappers(wrappers);
		wrappersHsty.setName(wrappers.getName());
		wrappersHsty.setCode(wrappers.getCatagoryCode()+wrappers.getCode());
		wrappersHsty.setMachineCode(wrappers.getMachineCode());
		wrappersHsty.setUserDefinedCode(wrappers.getUserDefinedCode());
		wrappersHsty.setUsedName(wrappers.getUsedName());
		wrappersHsty.setPreUnitCnvrsnFctr(wrappers.getPreUnitCnvrsnFctr());
		if(wrappers.getUnitsByQuantityUnitId1()!=null)
			wrappersHsty.setQuantityUnitName1(wrappers.getUnitsByQuantityUnitId1().getName());
		if(wrappers.getUnitsByQuantityUnitId2()!=null)
			wrappersHsty.setQuantityUnitName2(wrappers.getUnitsByQuantityUnitId2().getName());
		wrappersHsty.setUnitCnvrsnFctr(wrappers.getUnitCnvrsnFctr());
		if(wrappers.getUnitsByBaseQuantityUnitId()!=null)
			wrappersHsty.setQuantityUnitName2(wrappers.getUnitsByBaseQuantityUnitId().getName());
		wrappersHsty.setSpecialManageType(wrappers.getSpecialManageType());
		wrappersHsty.setStatus(wrappers.getStatus());
		wrappersHsty.setCrtTm(DateUtil.getCurrentTime());
		wrappersHsty.setCrtUsr(wrappers.getCrtUsr());
		wrappersHsty.setUpdTm(wrappers.getUpdTm());
		wrappersHsty.setUpdUsr(wrappers.getUpdUsr());
		baseDAO.save(wrappersHsty);
		return 0;
	}

	@Override
	public List<WrapperCatagoryDetails> getWrapperCatagoryDetail(Long Id)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<WrapperCatagoryDetails> list = baseDAO.findByHQL(
				"from WrapperCatagoryDetails where wrappers.id=?",
				new Object[] { Id });
		return list;
	}

	@Override
	public CatagoryDetails getCatagoryDetail(Long catagoryId)
			throws ServiceException {
		// TODO Auto-generated method stub
		CatagoryDetails catagoryDetails = baseDAO.findById(catagoryId,
				CatagoryDetails.class);
		return catagoryDetails;
	}

	@Override
	public int check(String id, String userId) throws ServiceException {
		// TODO Auto-generated method stub
		Wrappers wrappers=baseDAO.findById(Long.parseLong(id),Wrappers.class);
		if(userId.equals(wrappers.getUpdUsr())){
			return 1;
		}
		wrappers.setStatus(STATUS.ENABLE);
		wrappers.setCheckUsr(userId);
		wrappers.setCheckTm(DateUtil.getCurrentTime());
		
		baseDAO.update(wrappers);
		//更新历史表
		List<WrappersHsty> list=baseDAO.findByHQL("from WrappersHsty where wrappers.id=? order by crtTm desc",new Object[]{Long.parseLong(id)});
		if(list.size()>0){
			WrappersHsty h=list.get(0);
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
					+ "wrappers.code as code "
					+ "from wrappers "
					+ "where wrappers.ID "
					+ "not in(select 0 ";
			List params = new ArrayList();
			for (String s : catagoryDetailList) {
				if (!StringUtil.isEmpty(s)) {
					sql += "union "
							+ "select WRAPPER_ID from wrapper_catagory_details,catagory_details "
							+ "where wrapper_catagory_details.CATAGORY_DETAIL_ID=catagory_details.ID "
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
		String s=sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.IS_PACKAGE_EDIT_CHECK);
		if("1".equals(s)){
			return true;
		}
		return false;
	}

}
