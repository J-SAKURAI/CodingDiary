package com.huihuan.gmp.actions.baseSet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.baseSet.ICatagoryService;
import com.huihuan.gmp.services.baseSet.IProductService;
import com.huihuan.gmp.services.baseSet.ISameCatagoryService;
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.CatagoryVo;
import com.huihuan.gmp.vo.ProductVo;
import com.huihuan.gmp.vo.SameCatagoryVo;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ProductAction extends BaseAction {

	@Resource
	private IProductService productService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String isAbleAddProduct(){
		queryJson =new BaseJson();
		try {
			String sameCatagoryId=getHttpRequest().getParameter("sameCatagoryId");
			int result=productService.isAbleAddProduct(sameCatagoryId);
			if(result==1){
				queryJson.setRetcode("0004");
				queryJson.setErrorMsg("该同名类别下已存在规格为空的产品，不能添加其他产品！");
			}
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getProductLengthAndPreCode(){
		queryJson =new BaseJson();
		try {
			String sameCatagoryId=getHttpRequest().getParameter("sameCatagoryId");
			Map map = new HashMap();
			String length=productService.getProductCodeLength();
			String preCode=productService.getProductPreCode(sameCatagoryId);
			map.put("productLength", length);
			map.put("preProductCode", preCode);
			queryJson.setObj(map);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getProducts(){
		queryJson =new BaseJson();
		try {
			String keyword=getHttpRequest().getParameter("keyword");
			String productStatus=getHttpRequest().getParameter("productStatus");
			String catagoryDetails=getHttpRequest().getParameter("catagoryDetails");
			String sameCatagory=getHttpRequest().getParameter("sameCatagory");
			String queryPage=getHttpRequest().getParameter("queryPage");
			String pageSize=getHttpRequest().getParameter("pageSize");
			String orderPropoty=getHttpRequest().getParameter("orderPropoty");
			String orderType=getHttpRequest().getParameter("orderType");
			Map map = productService.getProducts(catagoryDetails, sameCatagory,queryPage,pageSize,keyword,productStatus,orderPropoty,orderType);
			queryJson.setObj(map);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String addProduct(){
		queryJson =new BaseJson();
		try {
			String itemId=getHttpRequest().getParameter("itemId");
			String sameCatagoryId=getHttpRequest().getParameter("sameCatagoryId");
        	String code=getHttpRequest().getParameter("code");
        	String machineCode=getHttpRequest().getParameter("machineCode");
        	String name=getHttpRequest().getParameter("name");
        	String materialId=getHttpRequest().getParameter("materialId");
        	String quantityUnit1=getHttpRequest().getParameter("quantityUnit1");
        	String quantityUnit2=getHttpRequest().getParameter("quantityUnit2");
        	String specialManageType=getHttpRequest().getParameter("specialManageType");
        	String specification=getHttpRequest().getParameter("specification");
        	String userDefinedCode=getHttpRequest().getParameter("userDefinedCode");
        	String usedName=getHttpRequest().getParameter("usedName");
        	String codeName=getHttpRequest().getParameter("codeName");
        	String productUnit=getHttpRequest().getParameter("productUnit");
        	String preUnitCnvrsnFctr=getHttpRequest().getParameter("preUnitCnvrsnFctr");
        	String unitCnvrsnFctr=getHttpRequest().getParameter("unitCnvrsnFctr");
        	String baseQuantityUnit=getHttpRequest().getParameter("baseQuantityUnit");
        	String approvalNumber=getHttpRequest().getParameter("approvalNumber");
        	String approvalNumberValidDate=getHttpRequest().getParameter("approvalNumberValidDate");
        	String storageCondition=getHttpRequest().getParameter("storageCondition");
        	String validityPeriod=getHttpRequest().getParameter("validityPeriod");
        	String warmingDay=getHttpRequest().getParameter("warmingDay");
			ProductVo vo=new ProductVo();
			vo.setId(itemId);
			vo.setSameCatagory(sameCatagoryId);
			vo.setMaterialId(materialId);
			vo.setCode(code);
			vo.setMachineCode(machineCode);
			vo.setName(name);
			vo.setQuantityUnit1(quantityUnit1);
			vo.setQuantityUnit2(quantityUnit2);
			vo.setSpecialManageType(specialManageType);
			vo.setSpecification(specification);
			vo.setUserDefinedCode(userDefinedCode);
			vo.setUsedName(usedName);
			vo.setCodeName(codeName);
			vo.setProductUnit(productUnit);
			vo.setPreUnitCnvrsnFctr(preUnitCnvrsnFctr);
			vo.setUnitCnvrsnFctr(unitCnvrsnFctr);
			vo.setBaseQuantityUnit(baseQuantityUnit);
			vo.setApprovalNumber(approvalNumber);
			vo.setApprovalNumberValidDate(approvalNumberValidDate);
			vo.setStorageCondition(storageCondition);
			vo.setValidityPeriod(validityPeriod);
			vo.setWarmingDay(warmingDay);
			vo.setUsrId(getLoginUserId());
			int result=productService.addProduct(vo);
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("产品名不能为空！");
			}else if(result==2){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("同一个同名类别下不能存在相同的产品名！");
			}else if(result==3){
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("该同名类别下已存在其他产品，规格不能为空！");
			}else if(result==4){
				queryJson.setRetcode("0004");
				queryJson.setErrorMsg("该同名类别下已存在规格为空的产品，不能添加其他产品！");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String deleteProduct(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			int result=productService.deleteProduct(id);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getProduct(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			ProductVo vo=productService.getProduct(id);
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	

	
	public String checkProduct(){
		queryJson =new BaseJson();
		try {
			String productId=getHttpRequest().getParameter("productId");
			int i=productService.checkProduct(productId,getLoginUserId());
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
	
	public String getProductHsty(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			ProductVo vo=productService.getProductHsty(id);
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
//	
//	public String editSameCatagory(){
//		queryJson =new BaseJson();
//		try {
//			String id=getHttpRequest().getParameter("itemId");
//			String name=getHttpRequest().getParameter("name");
//			String status=getHttpRequest().getParameter("status");
//			SameCatagoryVo vo=new SameCatagoryVo();
//			vo.setId(id);
//			vo.setName(name);
//			vo.setStatus(status);
//			int result=sameCatagoryService.editSameCatagory(vo);
//			queryJson.setObj(vo);
//		} catch (ServiceException e) {
//			// TODO: handle exception
//			processException(e, queryJson);
//		}
//		return "jsonResult";
//	}
//	
}
