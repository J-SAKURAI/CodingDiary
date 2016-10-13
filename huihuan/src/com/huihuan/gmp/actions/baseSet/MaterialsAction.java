package com.huihuan.gmp.actions.baseSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.MaterialCatagoryDetails;
import com.huihuan.gmp.entity.Materials;
import com.huihuan.gmp.entity.MaterialsHsty;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.baseSet.IMaterialsService;
import com.huihuan.gmp.services.baseSet.IProductService;
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.MaterialsVo;
import com.opensymphony.xwork2.ActionContext;

public class MaterialsAction extends BaseAction {

	@Resource
	private IMaterialsService materialsService;
	private IProductService productService;
	private BaseJson queryJson = new BaseJson();
	
	private File image; //文件
	private String imageFileName; //文件名
	private String imageContentType;//文件类型
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String uploadPhoto(){
		String picPath=null;
		try { 
			queryJson = new BaseJson();
			image=this.getImage();
			if(image!=null){
				//文件保存的父目录
				String realPath=ServletActionContext.getServletContext().getRealPath("file/image/material");
				//要保存的新的文件名称
				String targetFileName=StringUtil.generateFileName(imageFileName);
				picPath=targetFileName;
				//利用父子目录穿件文件目录
				File savefile=new File(new File(realPath),targetFileName);
				if(!savefile.getParentFile().exists()){
					savefile.getParentFile().mkdirs();
				}
				FileOutputStream fos=new FileOutputStream(savefile);
				FileInputStream fis=new FileInputStream(image);
				
				//如果复制文件的时候 出错了返回 值就是 -1 所以 初始化为 -2
				Long result=-2L;   //大文件的上传
				int  smresult=-2; //小文件的上传
				
				//如果文件大于 2GB
				if(image.length()>1024*2*1024){
					result=IOUtils.copyLarge(fis, fos);
				}else{
					smresult=IOUtils.copy(fis, fos); 
				}
	            if(result >-1 || smresult>-1){
	            	ActionContext.getContext().put("message", "上传成功！");
	            }
	            
	            ActionContext.getContext().put("filePath", targetFileName);
	            System.out.println("filePath:"+realPath+targetFileName);
	            
           }
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
		queryJson.setObj(picPath);
        return "jsonResult";
	}
	
	public String addMaterialDetail() {
		queryJson = new BaseJson();
		try {

			String catagoryId = getHttpRequest().getParameter("catagoryId");// 具体的原辅料分类码

			String name = getHttpRequest().getParameter("name");// 产品名
			
			
			String quantityUnit1=getHttpRequest().getParameter("quantityUnit1");
        	String quantityUnit2=getHttpRequest().getParameter("quantityUnit2");
			
        	String preUnitCnvrsnFctr=getHttpRequest().getParameter("preUnitCnvrsnFctr");


			
			String catagoryCode = getHttpRequest().getParameter("catagoryCode");// 分类编码
			String code = getHttpRequest().getParameter("code");// 编码
			String isMiddle = getHttpRequest().getParameter("isMiddle");// 是否中间体
			String productId = getHttpRequest().getParameter("productId");// 对应产品Id
			String userDefinedCode = getHttpRequest().getParameter(
					"userDefinedCode");// 自定义编码
			String usedName = getHttpRequest().getParameter("usedName");// 曾用名
			String quantityUnit = getHttpRequest().getParameter("quantityUnit");// 数量单位
			String unitCnvrsnFctr = getHttpRequest().getParameter(
					"unitCnvrsnFctr");// 单位转换系数
			String baseQuantityUnit = getHttpRequest().getParameter(
					"baseQuantityUnit");// 基础单位

			String isRepeatWeight = getHttpRequest().getParameter(
					"isRepeatWeight");// 是否入库复称
			String toleranceRange = getHttpRequest().getParameter(
					"toleranceRange");// 公差范围
			String repeatWeightFormula = getHttpRequest().getParameter(
					"repeatWeightFormula");// 入库复称公式
			String supplementFormula = getHttpRequest().getParameter(
					"supplementFormula");// 含量补差公式
			String specialManageType = getHttpRequest().getParameter(
					"specialManageType");// 特殊管理类别
			String minInventory = getHttpRequest().getParameter("minInventory");// 最小库存
			String maxInventory = getHttpRequest().getParameter("maxInventory");// 最大库存
			String storageCondition = getHttpRequest().getParameter(
					"storageCondition");// 存储条件
			String warmingDay = getHttpRequest().getParameter("warmingDay");// 有效期预警
			String status = getHttpRequest().getParameter("status");// 状态
			String validityPeriod=getHttpRequest().getParameter("validityPeriod");//有效期
			String photoUrl=getHttpRequest().getParameter("photoUrl");
			String validityManageType=getHttpRequest().getParameter("validityManageType");
			

			String machineCode = getHttpRequest().getParameter("machineCode");
			
			int result = materialsService.addMaterialDetail(catagoryId, name,quantityUnit1,quantityUnit2,
					catagoryCode, code, isMiddle, productId, userDefinedCode,
					usedName, preUnitCnvrsnFctr,unitCnvrsnFctr, baseQuantityUnit,
					isRepeatWeight, toleranceRange, repeatWeightFormula,
					supplementFormula, specialManageType, minInventory,
					maxInventory, storageCondition, warmingDay, status,validityPeriod,
					photoUrl,validityManageType,machineCode,getLoginUserId());

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

	public String updateMaterialDetail() {
		queryJson = new BaseJson();
		try {

			String Id = getHttpRequest().getParameter("Id");

			String name = getHttpRequest().getParameter("name");// 产品名
			
			
			String quantityUnit1=getHttpRequest().getParameter("quantityUnit1");
        	String quantityUnit2=getHttpRequest().getParameter("quantityUnit2");
			
        	String preUnitCnvrsnFctr=getHttpRequest().getParameter("preUnitCnvrsnFctr");

			
			String catagoryCode = getHttpRequest().getParameter("catagoryCode");// 分类编码
			String code = getHttpRequest().getParameter("code");// 编码
			String isMiddle = getHttpRequest().getParameter("isMiddle");// 是否中间体
			String productId = getHttpRequest().getParameter("productId");// 对应产品Id
			String userDefinedCode = getHttpRequest().getParameter(
					"userDefinedCode");// 自定义编码
			String usedName = getHttpRequest().getParameter("usedName");// 曾用名
			String quantityUnit = getHttpRequest().getParameter("quantityUnit");// 数量单位
			String unitCnvrsnFctr = getHttpRequest().getParameter(
					"unitCnvrsnFctr");// 单位转换系数
			String baseQuantityUnit = getHttpRequest().getParameter(
					"baseQuantityUnit");// 基础单位

			String isRepeatWeight = getHttpRequest().getParameter(
					"isRepeatWeight");// 是否入库复称
			String toleranceRange = getHttpRequest().getParameter(
					"toleranceRange");// 公差范围
			String repeatWeightFormula = getHttpRequest().getParameter(
					"repeatWeightFormula");// 入库复称公式
			String supplementFormula = getHttpRequest().getParameter(
					"supplementFormula");// 含量补差公式
			String specialManageType = getHttpRequest().getParameter(
					"specialManageType");// 特殊管理类别
			String minInventory = getHttpRequest().getParameter("minInventory");// 最小库存
			String maxInventory = getHttpRequest().getParameter("maxInventory");// 最大库存
			String storageCondition = getHttpRequest().getParameter(
					"storageCondition");// 存储条件
			String warmingDay = getHttpRequest().getParameter("warmingDay");// 有效期预警
			String status = getHttpRequest().getParameter("status");// 状态
			String validityPeriod=getHttpRequest().getParameter("validityPeriod");//有效期
			String photoUrl=getHttpRequest().getParameter("photoUrl");
			String validityManageType=getHttpRequest().getParameter("validityManageType");

			int result = materialsService.updateMaterialDetail(Id, name,quantityUnit1,quantityUnit2,
					catagoryCode, code, isMiddle, productId, userDefinedCode,
					usedName,preUnitCnvrsnFctr,unitCnvrsnFctr, baseQuantityUnit,
					isRepeatWeight, toleranceRange, repeatWeightFormula,
					supplementFormula, specialManageType, minInventory,
					maxInventory, storageCondition, warmingDay, status,validityPeriod,
					photoUrl,validityManageType,getLoginUserId());

		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String deleteMaterialDetail() {
		queryJson = new BaseJson();
		try {

			String id=getHttpRequest().getParameter("itemId");
			int result = materialsService.deleteMaterialDetail(id);

		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String getMaterialDetails() {
		queryJson = new BaseJson();
		try {
			String Id = getHttpRequest().getParameter("Id");
			Materials material = materialsService.getMaterialsDetails(Long.parseLong(Id));
			MaterialsVo vo = new MaterialsVo();

			List<MaterialCatagoryDetails> list = materialsService
					.getMaterialCatagoryDetail(Long.parseLong(Id));
			List catagory=new ArrayList();
			for(MaterialCatagoryDetails detail:list){

				
				CatagoryDetailVo cvo=new CatagoryDetailVo();
				Long catagoryId=detail.getCatagoryDetails().getId();
				CatagoryDetails c=materialsService.getCatagoryDetail(catagoryId);
				cvo.setId(c.getId());
				cvo.setCode(c.getCode());
				cvo.setName(c.getName());
				JSONObject obj=JSONObject.fromObject(cvo);
				catagory.add(obj);
			}
			//Long catagoryId = list.get(0).getCatagoryDetails().getId();

			vo.setId(material.getId());
			vo.setName(material.getName());
			vo.setCatagoryCode(material.getCatagoryCode());
			vo.setCatagoryId(catagory);
			

			vo.setCode(material.getCode());
			vo.setIsMiddle(material.getIsMiddle());
			vo.setProductName(materialsService.getProductName(Id));
			vo.setUserDefinedCode(material.getUserDefinedCode());
			vo.setUsedName(material.getUsedName());
			
			vo.setQuantityUnit1(material.getUnitsByQuantityUnitId1().getId().toString());
			vo.setQuantityUnit2(material.getUnitsByQuantityUnitId2().getId().toString());
			if(null!=material.getUnitsByBaseQuantityUnitId()){
				vo.setBaseQuantityUnit(material.getUnitsByBaseQuantityUnitId().getId().toString());
			}
			//vo.setQuantityUnit(material.getQuantityUnit());

			vo.setPreUnitCnvrsnFctr(material.getPreUnitCnvrsnFctr());
			vo.setUnitCnvrsnFctr(material.getUnitCnvrsnFctr());
			//vo.setBaseQuantityUnit(material.getBaseQuantityUnit());
			vo.setIsRepeatWeight(material.getIsRepeatWeight());
			vo.setToleranceRange(material.getToleranceRange());
			vo.setRepeatWeightFormula(material.getRepeatWeightFormula());
			vo.setSupplementFormula(material.getSupplementFormula());
			vo.setSpecialManageType(material.getSpecialManageType());
			vo.setValidityManageType(material.getValidityManageType());
			vo.setValidityPeriod(material.getValidityPeriod());
			vo.setMinInventory(material.getMinInventory());
			vo.setMaxInventory(material.getMaxInventory());
			vo.setStorageCondition(material.getStorageCondition());
			vo.setWarmingDay(material.getWarmingDay());
			vo.setStatus(material.getStatus());
			vo.setMachineCode(material.getMachineCode());
			vo.setPhotoUrl(material.getPhotoUrl());
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
	
	public String getMaterialHstyDetails() {
		queryJson = new BaseJson();
		try {
			String Id = getHttpRequest().getParameter("Id");
			MaterialsHsty materialHsty = materialsService.getMaterialsHstyDetails(Long.parseLong(Id));
			MaterialsVo vo = new MaterialsVo();

			List<MaterialCatagoryDetails> list = materialsService
					.getMaterialCatagoryDetail(materialHsty.getMaterials().getId());
			List catagory=new ArrayList();
			for(MaterialCatagoryDetails detail:list){

				
				CatagoryDetailVo cvo=new CatagoryDetailVo();
				Long catagoryId=detail.getCatagoryDetails().getId();
				CatagoryDetails c=materialsService.getCatagoryDetail(catagoryId);
				cvo.setId(c.getId());
				cvo.setCode(c.getCode());
				cvo.setName(c.getName());
				JSONObject obj=JSONObject.fromObject(cvo);
				catagory.add(obj);
			}
			//Long catagoryId = list.get(0).getCatagoryDetails().getId();

			vo.setName(materialHsty.getName());
			vo.setCatagoryCode(materialHsty.getCatagoryCode());
			vo.setCatagoryId(catagory);
			

			vo.setCode(materialHsty.getCode());
			vo.setProductName(materialsService.getProductName(materialHsty.getMaterials().getId()+""));
			vo.setUserDefinedCode(materialHsty.getUserDefinedCode());
			vo.setUsedName(materialHsty.getUsedName());
			
			vo.setQuantityUnit1(materialHsty.getQuantityUnitName1());
			vo.setQuantityUnit2(materialHsty.getQuantityUnitName2());
			vo.setBaseQuantityUnit(materialHsty.getBaseQuantityUnitName());
			vo.setPreUnitCnvrsnFctr(materialHsty.getPreUnitCnvrsnFctr());
			vo.setUnitCnvrsnFctr(materialHsty.getUnitCnvrsnFctr());
			vo.setSpecialManageType(materialHsty.getSpecialManageType());
			vo.setValidityManageType(materialHsty.getValidityManageType());
			vo.setValidityPeriod(materialHsty.getValidityPeriod());
			vo.setStorageCondition(materialHsty.getStorageCondition());
			vo.setWarmingDay(materialHsty.getWarmingDay());
			vo.setStatus(materialHsty.getStatus());
			vo.setMachineCode(materialHsty.getMachineCode());
			vo.setPhotoUrl(materialHsty.getPhotoUrl());
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

	public String getMaterials() {
		queryJson = new BaseJson();
		try {
			String catagoryDetails = getHttpRequest().getParameter(
					"catagoryDetails");
			String queryPage = getHttpRequest().getParameter("queryPage");
			String pageSize = getHttpRequest().getParameter("pageSize");
			String keyword = getHttpRequest().getParameter("keyword");
			String status = getHttpRequest().getParameter("rawMaterialStatus");
			String orderPropoty=getHttpRequest().getParameter("orderPropoty");
			String orderType=getHttpRequest().getParameter("orderType");
			Map map = materialsService.getMaterials(catagoryDetails, queryPage,
					pageSize, keyword, status,orderPropoty,orderType);
			queryJson.setObj(map);
		} catch (Exception e) {
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String checkMaterial(){
		queryJson =new BaseJson();
		try {
			String materialId=getHttpRequest().getParameter("materialId");
			int i=materialsService.check(materialId,getLoginUserId());
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
			String code=materialsService.getCurrentCode(catagoryDetails);
			queryJson.setObj(code);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
}
