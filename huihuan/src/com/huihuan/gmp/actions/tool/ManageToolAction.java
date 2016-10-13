package com.huihuan.gmp.actions.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.WrapperCatagoryDetails;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.baseSet.ISysPropotyService;
import com.huihuan.gmp.services.tool.IManageToolService;
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.SysPropotyVo;

import java.io.IOException;
import java.io.IOException;
public class ManageToolAction extends BaseAction {
private BaseJson queryJson =new BaseJson();
	
	@Resource
	IManageToolService manageToolService;
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String setSysPropotys(){
		queryJson =new BaseJson();
		try {
			
			String pwdminlength=getHttpRequest().getParameter("pwdminlength");
			String pwdvalidday=getHttpRequest().getParameter("pwdvalidday");
			String pwderrormaxcount=getHttpRequest().getParameter("pwderrormaxcount");
			String pwdminintensity=getHttpRequest().getParameter("pwdminintensity");
			String displayidentycode=getHttpRequest().getParameter("displayidentycode");
			int result=manageToolService.setSysPropotys(pwdminlength,pwdvalidday,pwderrormaxcount,pwdminintensity,displayidentycode);
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
	
	public String getSysPropotys(){
		queryJson =new BaseJson();
		try {
			Map result=manageToolService.getSysPropotys();       
			queryJson.setObj(result);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
}
