package com.huihuan.gmp.actions.baseSet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.CatagoryVo;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class CatagoryAction extends BaseAction {

	@Resource
	private ICatagoryService catagoryService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getCodesLength() {
		queryJson =new BaseJson();
		try {
			String type=getHttpRequest().getParameter("type");
			Map map = catagoryService.getCodesLength(type);
			queryJson.setObj(map);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String saveCodesLength() {
		queryJson =new BaseJson();
		try {
			String type=getHttpRequest().getParameter("type");
			String bitLength=getHttpRequest().getParameter("bitLength");
			String sameCatagoryLength=getHttpRequest().getParameter("sameCatagoryLength");
			int result = catagoryService.saveCodesLength(type, bitLength, sameCatagoryLength);
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("长度必须是正整数");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getCatagory(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			Catagories catagories = catagoryService.getEntity(id, Catagories.class);
			CatagoryVo vo=new CatagoryVo();
			BeanUtils.copyProperties(vo, catagories);
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getCatagories(){
		queryJson =new BaseJson();
		try {
			int type=Integer.parseInt(getHttpRequest().getParameter("type"));
			List list = catagoryService.getCatagoriesByType(type);
			queryJson.setObj(list);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}catch(Exception e){
			e.printStackTrace();
		} 
		return "jsonResult";
	}

	public String getUnSavedCatagories(){
		queryJson =new BaseJson();
		try {
			int type=Integer.parseInt(getHttpRequest().getParameter("type"));
			List<Catagories> list = catagoryService.getUnSavedCatagoriesByType(type);
			List results=new ArrayList();
			for(Catagories catagory :list){
				CatagoryVo vo=new CatagoryVo();
				BeanUtils.copyProperties(vo, catagory);
				results.add(vo);
			}
			queryJson.setObj(results);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}catch(Exception e){
			e.printStackTrace();

		} 
		return "jsonResult";
	}
	
	public String getCatagoriesAndDetails(){
		queryJson =new BaseJson();
		try {
			int type=Integer.parseInt(getHttpRequest().getParameter("type"));
			List list = catagoryService.getCatagoriesAndDetailsByType(type);
			queryJson.setObj(list);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String addCatagory(){
		queryJson =new BaseJson();
		try {
			String type=getHttpRequest().getParameter("type");
			String name=getHttpRequest().getParameter("tempName");
			String length=getHttpRequest().getParameter("tempLength");
			String rmk=getHttpRequest().getParameter("tempRmk");
			int result=catagoryService.addCatagory(Integer.parseInt(type), name, Integer.parseInt(length), rmk);
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("已存在相同名称的分类！");
			}else if(result==2){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("分类编码最多6级！");
			}else if(result==3){
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("级名称不能为空！");
			}else if(result==4){
				queryJson.setRetcode("0004");
				queryJson.setErrorMsg("已存在产品同名类别，无法增加！");
			}else if(result==5){
				queryJson.setRetcode("0005");
				queryJson.setErrorMsg("已存在原辅料，无法增加！");
			}else if(result==6){
				queryJson.setRetcode("0006");
				queryJson.setErrorMsg("已存在包装材料，无法增加！");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String resetCatagory(){
		queryJson =new BaseJson();
		try {
			int result=catagoryService.resetCatagory();
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String deleteCatagory(){
		queryJson =new BaseJson();
		try {
			String catagoryId=getHttpRequest().getParameter("itemId");
			int result=catagoryService.deleteCatagory(Long.parseLong(catagoryId));
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("该分类类别下已存在编码，无法删除！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String editCatagory(){
		try {
			String catagoryId=getHttpRequest().getParameter("itemId");
			String name=getHttpRequest().getParameter("tempName");
			String length=getHttpRequest().getParameter("tempLength");
			String rmk=getHttpRequest().getParameter("tempRmk");
			int result=catagoryService.editCatagory(Long.parseLong(catagoryId),name,Integer.parseInt(length), rmk);
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("已存在相同名称的分类！");
			}else if(result==2){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("已存在具体分类编码，无法修改位数！");
			}else if(result==3){
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("级名称不能为空！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getCatagoryDetails(){
		queryJson =new BaseJson();
		try {
			String catagoryId=getHttpRequest().getParameter("catagoryId");
			List<CatagoryDetails> list = catagoryService.getCatagoryDetails(catagoryId);
			Catagories catagories=catagoryService.getTypebyId(catagoryId);
			Integer type=catagories.getType();
			
			List results=new ArrayList();
			for(CatagoryDetails catagoryDetail:list){
				CatagoryDetailVo vo=new CatagoryDetailVo();
				String vl=null;
				if(type==2){
					vl=catagoryService.getPropertyVl("MATERIAL_LNGTH");
				}
				if(type==3){
					vl=catagoryService.getPropertyVl("WARPPERS_LNGTH");
				}
				vo.setLength(vl);
				BeanUtils.copyProperties(vo, catagoryDetail);
				results.add(vo);
			}
			queryJson.setObj(results);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String addCatagoryDetail(){
		queryJson =new BaseJson();
		try {
			String catagoryId=getHttpRequest().getParameter("catagoryId");
			String catagoryCd=getHttpRequest().getParameter("catagoryCd");
			String name=getHttpRequest().getParameter("name");
			int result=catagoryService.addCatagoryDetail(Long.parseLong(catagoryId), catagoryCd, name);
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("已存在相同的分类名称！");
			}else if(result==3){
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("分类名称不能为空！");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String deleteCatagoryDetail(){
		queryJson =new BaseJson();
		try {
			String catagoryDetailId=getHttpRequest().getParameter("catagoryDetailId");
			int result=catagoryService.deleteCatagoryDetail(Long.parseLong(catagoryDetailId));
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("已存在对应的同名类别编码，无法删除！");
			}else if(result==2){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("已存在对应的原辅料编码，无法删除！");
			}else if(result==3){
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("已存在对应的包装材料编码，无法删除！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String editCatagoryDetail(){
		try {
			String catagoryDetailId=getHttpRequest().getParameter("catagoryDetailId");
			String catagoryCd=getHttpRequest().getParameter("catagoryCd");
			String name=getHttpRequest().getParameter("name");
			int result=catagoryService.editCatagoryDetail(Long.parseLong(catagoryDetailId), catagoryCd, name);
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("已存在相同的分类名称！");
			}else if(result==3){
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("分类名称不能为空！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
}
