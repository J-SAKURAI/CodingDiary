package com.huihuan.gmp.actions.buyManagement;

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
import com.huihuan.gmp.services.buyManagement.ICompanyService;
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.CatagoryVo;
import com.huihuan.gmp.vo.ProductVo;
import com.huihuan.gmp.vo.SameCatagoryVo;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class CompanyAction extends BaseAction {

	@Resource
	private ICompanyService companyService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	
	public String getCompanies(){
		queryJson =new BaseJson();
		try {
			String keyword=getHttpRequest().getParameter("keyword");
			List list=companyService.getCompanies(keyword);
			queryJson.setObj(list);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String deleteCompany(){
		queryJson =new BaseJson();
		String id=getHttpRequest().getParameter("itemId");
		int i =companyService.deleteCompany(id);
		if(i!=0){
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("报错！");
		}
		return "jsonResult";
	}
}
