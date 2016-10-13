package com.huihuan.gmp.actions.baseSet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.struts2.convention.annotation.Action;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;

import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.FormulaMaterials;
import com.huihuan.gmp.entity.Formulas;
import com.huihuan.gmp.entity.Products;
import com.huihuan.gmp.vo.*;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.baseSet.IProductFormulaService;
import com.huihuan.gmp.services.baseSet.impl.CatagoryServiceImpl;




public class ProductFormulaAction extends BaseAction {
	
	@Resource
	private IProductFormulaService productFormulaService;
	private BaseJson queryJson = new BaseJson();
	public BaseJson getQueryJson() {
		return queryJson;
	}
	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	public String getProductFormulaList() {
		queryJson = new BaseJson();
		String[] catagoryList ={};
		try{
			String catagoryDetails=getHttpRequest().getParameter("catagoryDetails");
			String queryPage=getHttpRequest().getParameter("queryPage");
			String pageSize=getHttpRequest().getParameter("pageSize");
			String keyword=getHttpRequest().getParameter("keyword");
			String status=getHttpRequest().getParameter("status");
			if (catagoryDetails!=null){
				catagoryList = catagoryDetails.split("&");
				List<ProductFormulaVo> list=productFormulaService.getProductFormulaList(catagoryList,queryPage,pageSize,keyword,status);
				if (list!=null) {
					queryJson.setObj(list);
				}
				else{
					queryJson.setRetcode("0001");
					queryJson.setErrorMsg("查询结果为空");
				}
			}
		}
		catch (ServiceException e){
			processException(e, queryJson);
		}
		catch (Exception e){
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String getFormulasList(){
		queryJson = new BaseJson();
		try{
			String productId=getHttpRequest().getParameter("productId");
			List<FormulasVo> list=productFormulaService.getFormulasList(productId);
			if (list!=null) {
				queryJson.setRetcode("0000");
				queryJson.setObj(list);
			}
			else{
				queryJson.setRetcode("0001");
			}
		}
		catch (ServiceException e){
			processException(e, queryJson);
		}
		catch (Exception e){
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String deleteFormula(){
		queryJson = new BaseJson();
		try{
			String formulaId=getHttpRequest().getParameter("formulaId");
			int result=productFormulaService.deleteFormula(formulaId);
			if (result==0) {
				queryJson.setRetcode("0000");
			}
			else{
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("当前配方在用，删除失败");
			}
		}
		catch (ServiceException e){
			processException(e, queryJson);
		}
		catch (Exception e){
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getFormulasdetails(){
		queryJson = new BaseJson();
		try{
			String formulaId=getHttpRequest().getParameter("formulaId");
			List<FormulaMaterials> list = productFormulaService.getFormulasdetails(formulaId);
			String convertion = productFormulaService.getEntity(formulaId, Formulas.class).getConvertion();
			String instruction = productFormulaService.getEntity(formulaId, Formulas.class).getInstruction();
			Map map = new HashMap();
			map.put("formulalist",list);
			map.put("convertion",convertion);
			map.put("instruction",instruction);
			queryJson.setObj(map);
			queryJson.setRetcode("0000");
		}
		catch (ServiceException e){
			processException(e, queryJson);
		}
		catch (Exception e){
			processException(e, queryJson);
		}
		return "jsonResult";		
	}
	public String deleteFormulaItem(){
		queryJson = new BaseJson();
		try{
			String formulaitemId=getHttpRequest().getParameter("formulaitemId");
			int result = productFormulaService.deleteFormulaItem(formulaitemId);
			queryJson.setRetcode("0000");
		}
		catch (ServiceException e){
			processException(e, queryJson);
		}
		catch (Exception e){
			processException(e, queryJson);
		}
		return "jsonResult";		
	}
	public String getFormulaItem(){
		queryJson = new BaseJson();
		try{
			String formulaitemId=getHttpRequest().getParameter("formulaitemId");
			FormulaMaterialsVo instance = productFormulaService.getFormulaItem(formulaitemId);
			queryJson.setRetcode("0000");
			queryJson.setObj(instance);
		}
		catch (ServiceException e){
			processException(e, queryJson);
		}
		catch (Exception e){
			processException(e, queryJson);
		}
		return "jsonResult";	
		
	}
	public String getFormulagroup(){
		queryJson = new BaseJson();
		try{
			String formulaitemId=getHttpRequest().getParameter("formulaitemId");
			/*List<String> groupList = productFormulaService.getFormulagroup(formulaitemId);*/
			List<String> groupList = new ArrayList<String>(0);
			queryJson.setRetcode("0000");
			queryJson.setObj(groupList);
		}
/*		catch (ServiceException e){
			processException(e, queryJson);
		}*/
		catch (Exception e){
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	public String getGroup(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			GroupVo vo=productFormulaService.getGroup(id);
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";

	}
	public String getGroups(){
		queryJson =new BaseJson();
		try {
			List list = productFormulaService.getGroups();
			queryJson.setObj(list);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String addGroup(){
		queryJson =new BaseJson();
		try {
			String name=getHttpRequest().getParameter("name");
			GroupVo vo=new GroupVo();
			vo.setName(name);
			int result=productFormulaService.addGroup(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	public String deleteGroup(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			int result=productFormulaService.deleteGroup(id);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	public String editGroup(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			String name=getHttpRequest().getParameter("name");
			GroupVo vo=new GroupVo();
			vo.setId(id);
			vo.setName(name);
			int result=productFormulaService.editGroup(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String saveFormula(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("formulaid");			
			String instruction=getHttpRequest().getParameter("instruction");
			String convertion=getHttpRequest().getParameter("convertion");
			int result = productFormulaService.saveFormula(id,instruction,convertion);
			queryJson.setRetcode("0000");
			queryJson.setErrorMsg("");
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getCatagoriesAndDetails(){
		queryJson = new BaseJson();
		int type = Integer.parseInt(getHttpRequest().getParameter("type"));
		List list=productFormulaService.getCatagoriesAndDetailsByType(type);
		if(list!=null){
			queryJson.setObj(list);
			queryJson.setRetcode("0000");
		}
		else{
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("不存在内容");
		}
		return "jsonResult";
	}
	
	public String getProducts(){
		queryJson = new BaseJson();
		String productDetails=getHttpRequest().getParameter("productDetails");
		List list = productFormulaService.getProductListById(productDetails);
		if(list!=null){
			queryJson.setObj(list);
			queryJson.setRetcode("0000");
		}
		else{
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("不存在内容");
		}
		return "jsonResult";
		
	}
	
}
