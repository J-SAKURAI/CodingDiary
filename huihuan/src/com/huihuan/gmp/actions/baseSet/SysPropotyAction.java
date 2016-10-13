package com.huihuan.gmp.actions.baseSet;

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
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.SysPropotyVo;

import java.io.IOException;
import java.io.IOException;
public class SysPropotyAction extends BaseAction {
private BaseJson queryJson =new BaseJson();
	
	@Resource
	ISysPropotyService sysPropotyService;
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getCodesTypes() {
		queryJson =new BaseJson();
		try {
			Map map = sysPropotyService.getCodeTypes();
			queryJson.setObj(map);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String saveCodesTypes() {
		queryJson =new BaseJson();
		try {
			String productCodeType=getHttpRequest().getParameter("productCodeType");
			String materialCodeType=getHttpRequest().getParameter("materialCodeType");
			String packageCodeType=getHttpRequest().getParameter("packageCodeType");
			int i = sysPropotyService.saveCodeTypes(productCodeType,materialCodeType,packageCodeType);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getMachineCode(){
		queryJson =new BaseJson();
		try {
			String s = sysPropotyService.getMachineCode();
			queryJson.setObj(s);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getSysPropotys(){
		queryJson =new BaseJson();
		try {			
			String queryPage = getHttpRequest().getParameter("queryPage");
			String keyword=getHttpRequest().getParameter("keyword");
			String pageSize = getHttpRequest().getParameter("pageSize");
			String orderPropoty=getHttpRequest().getParameter("orderPropoty");
			String orderType=getHttpRequest().getParameter("orderType");
			Map map = sysPropotyService.getSysPropotys(queryPage,pageSize, keyword,orderPropoty,orderType);
			queryJson.setObj(map);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getSysPropotysDetails() {
		queryJson = new BaseJson();
		try {
			String Id = getHttpRequest().getParameter("itemId");
			SysProperty sysPropotys = sysPropotyService.getSysPropotysDetails(Long
					.parseLong(Id));
			SysPropotyVo vo = new SysPropotyVo();
			
			vo.setId(sysPropotys.getId());
			vo.setKy(sysPropotys.getPropotyKey());
			vo.setMlCd(sysPropotys.getMdlCd());
			vo.setRmk(sysPropotys.getRmk());
			vo.setValue(sysPropotys.getPropotyVl());
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
	
	public String deleteSysPropotyItem(){		
		queryJson = new BaseJson();
		try {
			String id = getHttpRequest().getParameter("itemId");
			int result = sysPropotyService.deleteSysPropotyItem(id);
			if (result == 0) {
				queryJson.setRetcode("0000");
			} else {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("删除失败！");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String addSysPropotyItem(){
		queryJson =new BaseJson();
		try{
			String mlCd=getHttpRequest().getParameter("mlCd");
			String ky=getHttpRequest().getParameter("ky");
			String value=getHttpRequest().getParameter("value");			
			String rmk=getHttpRequest().getParameter("rmk");		
			int result=sysPropotyService.addSysPropotyItem(mlCd,ky, value,rmk);
			}
			catch (ServiceException e) {
				// TODO: handle exception
				processException(e, queryJson);
			}
			return "jsonResult";
	}
	
	public String editSysPropotyItem() {
		queryJson = new BaseJson();
		try {
			String id = getHttpRequest().getParameter("itemId");
			String mlCd = getHttpRequest().getParameter("mlCd");
			String value = getHttpRequest().getParameter("value");
			String ky = getHttpRequest().getParameter("ky");
			String rmk = getHttpRequest().getParameter("rmk");
			
			int result = sysPropotyService.editSysPropotyItem(id, mlCd,ky,value,rmk);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
}
