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
import com.huihuan.gmp.services.baseSet.IUnitService;
import com.huihuan.gmp.services.baseSet.ISameCatagoryService;
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.CatagoryVo;
import com.huihuan.gmp.vo.UnitVo;
import com.huihuan.gmp.vo.SameCatagoryVo;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class UnitAction extends BaseAction {

	@Resource
	private IUnitService unitService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getUnits(){
		queryJson =new BaseJson();
		try {
			String type=getHttpRequest().getParameter("type");
			List list = unitService.getUnits(type);
			queryJson.setObj(list);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getQuantityUnit2ByQuantityUnit(){
		queryJson =new BaseJson();
		try {
			String quantityUnitId=getHttpRequest().getParameter("quantityUnitId");
			List list = unitService.getQuantityUnit2ByQuantityUnit(quantityUnitId);
			queryJson.setObj(list);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getBaseQuantityUnitByQuantityUnit(){
		queryJson =new BaseJson();
		try {
			String quantityUnitId=getHttpRequest().getParameter("quantityUnitId");
			List list = unitService.getBaseQuantityUnitByQuantityUnit(quantityUnitId);
			queryJson.setObj(list);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String addUnit(){
		queryJson =new BaseJson();
		try {
			String name=getHttpRequest().getParameter("name");
			UnitVo vo=new UnitVo();
			vo.setName(name);
			int result=unitService.addUnit(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String deleteUnit(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			int result=unitService.deleteUnit(id);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getUnit(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			UnitVo vo=unitService.getUnit(id);
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String editUnit(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			String name=getHttpRequest().getParameter("name");
			UnitVo vo=new UnitVo();
			vo.setId(id);
			vo.setName(name);
			int result=unitService.editUnit(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
}
