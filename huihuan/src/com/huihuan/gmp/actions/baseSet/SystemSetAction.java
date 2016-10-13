package com.huihuan.gmp.actions.baseSet;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.cst.Constants;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.baseSet.ISystemSetService;
import com.huihuan.gmp.services.tool.IUserChoiceService;
import com.huihuan.gmp.vo.UnitVo;
public class SystemSetAction extends BaseAction {
	private BaseJson queryJson =new BaseJson();
	@Resource
	ISystemSetService systemSetService;
	
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getSysPropotys(){
		queryJson =new BaseJson();
		
		try {
			Map result=systemSetService.getSysPropotys();   
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String setRecipeSysPropoty(){
		queryJson =new BaseJson();
		try {
			String isFeedDifferenceControl=getHttpRequest().getParameter("isFeedDifferenceControl");
			String isEditRecipe1=getHttpRequest().getParameter("isEditRecipe1");
			String isEditRecipe2=getHttpRequest().getParameter("isEditRecipe2");
			String feeddifference=getHttpRequest().getParameter("feeddifference");
			String editRecipe1=getHttpRequest().getParameter("editRecipe1");
			String editRecipe2=getHttpRequest().getParameter("editRecipe2");
			
			int result=systemSetService.setRecipeSysPropoty(feeddifference,isFeedDifferenceControl,isEditRecipe1,
					editRecipe1,isEditRecipe2,editRecipe2);
			
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("修改失败！");
            if(result==0)
            	queryJson.setRetcode("0000");           
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String setProductEditSysPropoty(){
		queryJson =new BaseJson();
		try {
			String isProductEditChecked=getHttpRequest().getParameter("isProductEditChecked");
			
			int result=systemSetService.setProductEditSysPropoty(isProductEditChecked);
			
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("修改失败！");
            if(result==0)
            	queryJson.setRetcode("0000");           
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	public String setPackingEditSysPropoty(){
		queryJson =new BaseJson();
		try {
			String isPackingEditChecked=getHttpRequest().getParameter("isPackingEditChecked");
			
			int result=systemSetService.setPackingEditSysPropoty(isPackingEditChecked);
			
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("修改失败！");
            if(result==0)
            	queryJson.setRetcode("0000");           
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	public String setMaterialEditSysPropoty(){
		queryJson =new BaseJson();
		try {
			String isMaterialCodingEditChecked=getHttpRequest().getParameter("isMaterialCodingEditChecked");
			String isMaterialNameSave=getHttpRequest().getParameter("isMaterialNameSave");
			
			int result=systemSetService.setMaterialEditSysPropoty(isMaterialCodingEditChecked,isMaterialNameSave);
			
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("修改失败！");
            if(result==0)
            	queryJson.setRetcode("0000");           
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String setProductSysPropoty(){
		queryJson =new BaseJson();
		try {
			String isMaterialEditChecked=getHttpRequest().getParameter("isMaterialEditChecked");
			String isPackingDefine1=getHttpRequest().getParameter("isPackingDefine1");
			String isPackingDefine2=getHttpRequest().getParameter("isPackingDefine2");
			String packingDefine1=getHttpRequest().getParameter("packingDefine1");
			String packingDefine2=getHttpRequest().getParameter("packingDefine2");
			
			int result=systemSetService.setProductSysPropoty(isMaterialEditChecked,isPackingDefine1,packingDefine1,
					isPackingDefine2,packingDefine2);
			
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("修改失败！");
            if(result==0)
            	queryJson.setRetcode("0000");           
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String setHrSysPropoty(){
		queryJson =new BaseJson();
		try {
			String isEmployeeECard=getHttpRequest().getParameter("isEmployeeECard");
			String defaultPasswd=getHttpRequest().getParameter("defaultPasswd");
			
			int result=systemSetService.setHrSysPropoty(defaultPasswd,isEmployeeECard);
			
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("修改失败！");
            if(result==0)
            	queryJson.setRetcode("0000");           
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
}