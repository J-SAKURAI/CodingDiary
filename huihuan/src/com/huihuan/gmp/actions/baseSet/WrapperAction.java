package com.huihuan.gmp.actions.baseSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.MaterialCatagoryDetails;
import com.huihuan.gmp.entity.WrapperCatagoryDetails;
import com.huihuan.gmp.entity.Wrappers;
import com.huihuan.gmp.entity.WrappersHsty;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.baseSet.IWrapperService;
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.WrappersVo;

public class WrapperAction extends BaseAction {

	@Resource
	private IWrapperService wrapperService;

	private BaseJson queryJson = new BaseJson();

	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;

	}

	public String addWrapperDetail() {
		queryJson = new BaseJson();
		try {

			String catagoryId = getHttpRequest().getParameter("catagoryId");// 具体的原辅料分类码

			String name = getHttpRequest().getParameter("name");
			
			String quantityUnit1=getHttpRequest().getParameter("quantityUnit1");
        	String quantityUnit2=getHttpRequest().getParameter("quantityUnit2");
			
			
			
			String catagoryCode = getHttpRequest().getParameter("catagoryCode");
			String code = getHttpRequest().getParameter("code");

			String userDefinedCode = getHttpRequest().getParameter(
					"userDefinedCode");
			String usedName = getHttpRequest().getParameter("usedName");
			//String quantityUnit = getHttpRequest().getParameter("quantityUnit");
			
			
        	String preUnitCnvrsnFctr=getHttpRequest().getParameter("preUnitCnvrsnFctr");

			
			String unitCnvrsnFctr = getHttpRequest().getParameter(
					"unitCnvrsnFctr");
			String baseQuantityUnit = getHttpRequest().getParameter(
					"baseQuantityUnit");
			String isRepeatWeight = getHttpRequest().getParameter(
					"isRepeatWeight");
			String toleranceRange = getHttpRequest().getParameter(
					"toleranceRange");
			String repeatWeightFormula = getHttpRequest().getParameter(
					"repeatWeightFormula");
			String specialManageType = getHttpRequest().getParameter(
					"specialManageType");

			String status = getHttpRequest().getParameter("status");
			

			String machineCode = getHttpRequest().getParameter("machineCode");

			int result = wrapperService.addWrapperDetail(catagoryId,
					name,quantityUnit1,quantityUnit2,catagoryCode, code, userDefinedCode, usedName,
					preUnitCnvrsnFctr,unitCnvrsnFctr, baseQuantityUnit,
					isRepeatWeight, toleranceRange, repeatWeightFormula,
					specialManageType, status,machineCode,getLoginUserId());
			if (result == 1) {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("已存在相同的原辅料！");
			}

			if (result == 2) {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("序数位相同，增加无效！");
			}
			
			if(result==3){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("用户自定义编码相同，增加无效！");
			}

		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String updateWrapperDetail() {
		queryJson = new BaseJson();
		try {

			String Id = getHttpRequest().getParameter("Id");// 材料总类的类型

			String name = getHttpRequest().getParameter("name");
			
			String quantityUnit1=getHttpRequest().getParameter("quantityUnit1");
        	String quantityUnit2=getHttpRequest().getParameter("quantityUnit2");
			
        	String preUnitCnvrsnFctr=getHttpRequest().getParameter("preUnitCnvrsnFctr");

        	
			String catagoryCode = getHttpRequest().getParameter("catagoryCode");
			String code = getHttpRequest().getParameter("code");

			String userDefinedCode = getHttpRequest().getParameter(
					"userDefinedCode");
			String usedName = getHttpRequest().getParameter("usedName");
			//String quantityUnit = getHttpRequest().getParameter("quantityUnit");
			String unitCnvrsnFctr = getHttpRequest().getParameter(
					"unitCnvrsnFctr");
			String baseQuantityUnit = getHttpRequest().getParameter(
					"baseQuantityUnit");
			String isRepeatWeight = getHttpRequest().getParameter(
					"isRepeatWeight");
			String toleranceRange = getHttpRequest().getParameter(
					"toleranceRange");
			String repeatWeightFormula = getHttpRequest().getParameter(
					"repeatWeightFormula");
			String specialManageType = getHttpRequest().getParameter(
					"specialManageType");

			String status = getHttpRequest().getParameter("status");

			int result = wrapperService.updateWrapperDetail(Id, name,quantityUnit1,quantityUnit2,
					catagoryCode, code, userDefinedCode, usedName,preUnitCnvrsnFctr,
					unitCnvrsnFctr, baseQuantityUnit,
					isRepeatWeight, toleranceRange, repeatWeightFormula,
					specialManageType, status,getLoginUserId());

		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String deleteWrapperDetail() {
		queryJson = new BaseJson();
		try {

			String id=getHttpRequest().getParameter("itemId");
			int result = wrapperService.deleteWrapperDetail(id);

		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String getWrapperDetails() {
		queryJson = new BaseJson();
		try {
			String Id = getHttpRequest().getParameter("Id");
			Wrappers wrappers = wrapperService.getWrappersDetails(Long
					.parseLong(Id));
			WrappersVo vo = new WrappersVo();
			
			List<WrapperCatagoryDetails> list=wrapperService.getWrapperCatagoryDetail(Long.parseLong(Id));
			
			
			List catagory=new ArrayList();
			for(WrapperCatagoryDetails detail:list){
				CatagoryDetailVo cvo=new CatagoryDetailVo();
				Long catagoryId=detail.getCatagoryDetails().getId();
				CatagoryDetails c = wrapperService.getCatagoryDetail(catagoryId);
				
				cvo.setId(c.getId());
				cvo.setCode(c.getCode());
				cvo.setName(c.getName());
				JSONObject obj=JSONObject.fromObject(cvo);
				catagory.add(obj);
			}
			
			
			vo.setId(wrappers.getId());
			vo.setName(wrappers.getName());
			vo.setCatagoryCode(wrappers.getCatagoryCode());
			vo.setCatagoryId(catagory);
			vo.setCode(wrappers.getCode());
			vo.setUserDefinedCode(wrappers.getUserDefinedCode());
			vo.setUsedName(wrappers.getUsedName());
			if(null!=wrappers.getUnitsByQuantityUnitId1()){
				vo.setQuantityUnit1(wrappers.getUnitsByQuantityUnitId1().getId().toString());
			}
			if(null!=wrappers.getUnitsByQuantityUnitId2()){
				vo.setQuantityUnit2(wrappers.getUnitsByQuantityUnitId2().getId().toString());
			}
			if(null!=wrappers.getUnitsByBaseQuantityUnitId()){
				vo.setBaseQuantityUnit(wrappers.getUnitsByBaseQuantityUnitId().getId().toString());
			}
			vo.setPreUnitCnvrsnFctr(wrappers.getPreUnitCnvrsnFctr());
			//vo.setQuantityUnit(wrappers.getQuantityUnit());
			vo.setUnitCnvrsnFctr(wrappers.getUnitCnvrsnFctr());
			//vo.setBaseQuantityUnit(wrappers.getBaseQuantityUnit());
			vo.setIsRepeatWeight(wrappers.getIsRepeatWeight());
			vo.setToleranceRange(wrappers.getToleranceRange());
			vo.setRepeatWeightFormula(wrappers.getRepeatWeightFormula());
			vo.setSpecialManageType(wrappers.getSpecialManageType());
			vo.setStatus(wrappers.getStatus());
			vo.setMachineCode(wrappers.getMachineCode());
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String getWrapperHstyDetails() {
		queryJson = new BaseJson();
		try {
			String Id = getHttpRequest().getParameter("Id");
			WrappersHsty wrappersHsty = wrapperService.getWrappersHstyDetails(Long
					.parseLong(Id));
			WrappersVo vo = new WrappersVo();
			
			List<WrapperCatagoryDetails> list=wrapperService.getWrapperCatagoryDetail(wrappersHsty.getWrappers().getId());
			
			
			List catagory=new ArrayList();
			for(WrapperCatagoryDetails detail:list){
				CatagoryDetailVo cvo=new CatagoryDetailVo();
				Long catagoryId=detail.getCatagoryDetails().getId();
				CatagoryDetails c = wrapperService.getCatagoryDetail(catagoryId);
				
				cvo.setId(c.getId());
				cvo.setCode(c.getCode());
				cvo.setName(c.getName());
				JSONObject obj=JSONObject.fromObject(cvo);
				catagory.add(obj);
			}
			
			vo.setName(wrappersHsty.getName());
			vo.setCatagoryId(catagory);
			vo.setCode(wrappersHsty.getCode());
			vo.setUserDefinedCode(wrappersHsty.getUserDefinedCode());
			vo.setUsedName(wrappersHsty.getUsedName());
			vo.setQuantityUnit1(wrappersHsty.getQuantityUnitName1());
			vo.setQuantityUnit2(wrappersHsty.getQuantityUnitName2());
			vo.setBaseQuantityUnit(wrappersHsty.getBaseQuantityUnitName());
			vo.setPreUnitCnvrsnFctr(wrappersHsty.getPreUnitCnvrsnFctr());
			vo.setUnitCnvrsnFctr(wrappersHsty.getUnitCnvrsnFctr());
			vo.setSpecialManageType(wrappersHsty.getSpecialManageType());
			vo.setStatus(wrappersHsty.getStatus());
			vo.setMachineCode(wrappersHsty.getMachineCode());
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String getWrappers() {
		queryJson = new BaseJson();
		try {
			String catagoryDetails = getHttpRequest().getParameter(
					"catagoryDetails");
			String queryPage = getHttpRequest().getParameter("queryPage");
			String pageSize = getHttpRequest().getParameter("pageSize");
			String keyword = getHttpRequest().getParameter("keyword");
			String status = getHttpRequest().getParameter("pacMaterialStatus");
			String orderPropoty=getHttpRequest().getParameter("orderPropoty");
			String orderType=getHttpRequest().getParameter("orderType");
			Map map = wrapperService.getWrappers(catagoryDetails, queryPage,
					pageSize, keyword, status,orderPropoty,orderType);
			System.out.println("hello" + map.size());
			queryJson.setObj(map);
		} catch (Exception e) {
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String checkWrapper(){
		queryJson =new BaseJson();
		try {
			String wrapperId=getHttpRequest().getParameter("wrapperId");
			int i=wrapperService.check(wrapperId,getLoginUserId());
			if(i==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("审核人不能是编辑人！");
			}
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getCurrentCode(){
		queryJson =new BaseJson();
		try {
			String catagoryDetails = getHttpRequest().getParameter("catagoryDetails");
			String code=wrapperService.getCurrentCode(catagoryDetails);
			queryJson.setObj(code);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
}
