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
import com.huihuan.gmp.services.baseSet.ISameCatagoryService;
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.CatagoryVo;
import com.huihuan.gmp.vo.SameCatagoryVo;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class SameCatagoryAction extends BaseAction {

	@Resource
	private ISameCatagoryService sameCatagoryService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getSameCatagoryLength(){
		queryJson =new BaseJson();
		try {
			String length = sameCatagoryService.getSameCatagoryLength();
			queryJson.setObj(length);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getSameCatagories(){
		queryJson =new BaseJson();
		try {
			String catagoryDetails=getHttpRequest().getParameter("catagoryDetails");
			String keyword=getHttpRequest().getParameter("keyword");
			String samaCatagoryStatus=getHttpRequest().getParameter("samaCatagoryStatus");
			String orderPropoty=getHttpRequest().getParameter("orderPropoty");
			String orderType=getHttpRequest().getParameter("orderType");
			List list = sameCatagoryService.getSameCatagories(catagoryDetails,keyword,samaCatagoryStatus,orderPropoty,orderType);
			queryJson.setObj(list);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String addSameCatagory(){
		queryJson =new BaseJson();
		try {
			String code=getHttpRequest().getParameter("code");
			String name=getHttpRequest().getParameter("name");
			String status=getHttpRequest().getParameter("status");
			String catagoryDetails=getHttpRequest().getParameter("catagoryDetails");
			SameCatagoryVo vo=new SameCatagoryVo();
			vo.setName(name);
			vo.setCode(code);
			vo.setStatus(status);
			int result=sameCatagoryService.addSameCatagory(vo, catagoryDetails);
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("同名类别名称不能为空！");
			}else if(result==3){
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("同名类别名称不能重复！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String deleteSameCatagory(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			int result=sameCatagoryService.deleteSameCatagory(id);
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("同名类别下已有产品，无法删除！");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getSameCatagory(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			SameCatagoryVo vo=sameCatagoryService.getSameCatagory(id);
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String editSameCatagory(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			String name=getHttpRequest().getParameter("name");
			String status=getHttpRequest().getParameter("status");
			SameCatagoryVo vo=new SameCatagoryVo();
			vo.setId(id);
			vo.setName(name);
			vo.setStatus(status);
			int result=sameCatagoryService.editSameCatagory(vo);
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("同名类别名称不能为空！");
			}else if(result==3){
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("同名类别名称不能重复！");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
}
