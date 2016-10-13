package com.huihuan.gmp.actions.workShop;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.Crafts;
import com.huihuan.gmp.entity.ProductLinesWorkSteps;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.workShop.IWorkShopService;
import com.huihuan.gmp.vo.CraftVo;
import com.huihuan.gmp.vo.WarehouseVo;
import com.huihuan.gmp.vo.WrkSpNodeVo;

public class WorkShopAction extends BaseAction{
	@Resource
	private IWorkShopService workShopService;
	private BaseJson queryJson = new BaseJson();

	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	
	public String addWorkShop(){
		queryJson = new BaseJson();
		String name=getHttpRequest().getParameter("name");
		try {
			long result=workShopService.addWorkShop(name);
			queryJson.setObj(result);
			if(result==-1){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("车间名已存在");
			}
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
		return "jsonResult";
	}
	
	
	public String addProductionLines() {
      queryJson = new BaseJson();
      long workShopId =Long.parseLong(getHttpRequest().getParameter("workShopId"));
      long craftsId =Long.parseLong(getHttpRequest().getParameter("craftsId"));
      try {
			int result=workShopService.addProductLine(workShopId, craftsId);
			if(result==1){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("生产线已存在");
			}
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
		return "jsonResult";
	}
	
	
	public String deleteWorkShop(){
		queryJson = new BaseJson();
		long workShopId =Long.parseLong(getHttpRequest().getParameter("workShopId"));
		try {
			int result=workShopService.deleteWorkShop(workShopId);
			if(result==1){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("车间不存在");
			}else if(result==2){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("车间下存在作业室，无法删除。");
			}
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
		
		return "jsonResult";		
	}
	
	
	public String deleteProductionLine(){
		queryJson = new BaseJson();
		long productionLineId =Long.parseLong(getHttpRequest().getParameter("productionLineId"));
		try {
			int result=workShopService.deleteProductionLine(productionLineId);
			if(result==1){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("生产线不存在");
			}else if(result==2){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("生产线下存在作业室，无法删除。");
			}
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
		return "jsonResult";		
	}
	
	
	public String setWorkSteps(){
		queryJson = new BaseJson();
		long productLine_workStepId =Long.parseLong(getHttpRequest().getParameter("productLine_workStepId"));
		long wareHouseId =Long.parseLong(getHttpRequest().getParameter("wareHouseId"));
		int aft_rcv_auto_invst=Integer.parseInt(getHttpRequest().getParameter("aft_rcv_auto_invst"));
		int self_picking=Integer.parseInt(getHttpRequest().getParameter("self_picking"));
		int rcv_dfct=Integer.parseInt(getHttpRequest().getParameter("rcv_dfct"));
		int sign_in=Integer.parseInt(getHttpRequest().getParameter("sign_in"));
		int clear_area=Integer.parseInt(getHttpRequest().getParameter("clear_area"));
		int clear_area_tm_spc=Integer.parseInt(getHttpRequest().getParameter("clear_area_tm_spc"));
		int clear_area_tm_btch=Integer.parseInt(getHttpRequest().getParameter("clear_area_tm_btch"));
		int btch_rvw_mod=Integer.parseInt(getHttpRequest().getParameter("btch_rvw_mod"));
		int btch_prd_sort_out=Integer.parseInt(getHttpRequest().getParameter("btch_prd_sort_out"));
		int wgh_rcv_mtrl=Integer.parseInt(getHttpRequest().getParameter("wgh_rcv_mtrl"));
		int wgh_ptin_mtrl=Integer.parseInt(getHttpRequest().getParameter("wgh_ptin_mtrl"));
		int wgh_mid_prd=Integer.parseInt(getHttpRequest().getParameter("wgh_mid_prd"));
		int wgh_trn_out_mtrl=Integer.parseInt(getHttpRequest().getParameter("wgh_trn_out_mtrl"));
		int mid_prd_lbl=Integer.parseInt(getHttpRequest().getParameter("mid_prd_lbl"));
		int rcv_raw_mtrl_lbl=Integer.parseInt(getHttpRequest().getParameter("rcv_raw_mtrl_lbl"));
		int rcv_pack_mtrl_lbl=Integer.parseInt(getHttpRequest().getParameter("rcv_pack_mtrl_lbl"));
		int trn_t_mid_prd_lbl=Integer.parseInt(getHttpRequest().getParameter("trn_t_mid_prd_lbl"));
		int trn_t_rcv_prd_lbl=Integer.parseInt(getHttpRequest().getParameter("trn_t_rcv_prd_lbl"));
		int put_in_mtrl_lbl=Integer.parseInt(getHttpRequest().getParameter("put_in_mtrl_lbl"));
		try {
			int result=workShopService.setWorkSteps ( productLine_workStepId,
					 wareHouseId,  aft_rcv_auto_invst,  self_picking,
					 rcv_dfct,  sign_in,  clear_area,  clear_area_tm_spc,
					 clear_area_tm_btch,  btch_rvw_mod,  btch_prd_sort_out,
					 wgh_rcv_mtrl,  wgh_ptin_mtrl,  wgh_mid_prd,
					 wgh_trn_out_mtrl,  mid_prd_lbl,  rcv_raw_mtrl_lbl,
					 rcv_pack_mtrl_lbl,  trn_t_mid_prd_lbl,
					 trn_t_rcv_prd_lbl,  put_in_mtrl_lbl);
			if(result==1){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("生产线不存在");
			}else if(result==2){
				queryJson.setRetcode("0002");
				queryJson.setErrorMsg("生产线下存在作业室，无法删除。");
			}
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
		return "jsonResult";	
	}
	
	
	public String getWorkShopTree(){
		queryJson = new BaseJson();
		try {
			List<WrkSpNodeVo> result=workShopService.getWorkShopTree();
			queryJson.setObj(result);
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
		
		return "jsonResult";		
	}
	
	public String getWorkShopProductLines(){
		queryJson = new BaseJson();
		try {
			List<CraftVo> result=workShopService.getWorkShopProductLines();
			queryJson.setObj(result);
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
			
		return "jsonResult";			
	}
	public String getcraftsunseted(){
		queryJson = new BaseJson();
		try {
			long workshopid=Long.parseLong(getHttpRequest().getParameter("workshopId"));
			List<CraftVo> result=workShopService.getcrafts_unseted(workshopid);
			queryJson.setObj(result);
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
			
		return "jsonResult";	
	}
	public String getworkstepsinformation(){
		long productLine_workStepId =Long.parseLong(getHttpRequest().getParameter("productLine_workStepId"));
		try {
			ProductLinesWorkSteps result=workShopService.getworkstepsinformation(productLine_workStepId);
			queryJson.setObj(result);
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
		return "jsonResult";
	}
	public String getmidwarehouse(){
		try {
			List<WarehouseVo> result=workShopService.getMidWarehouses();
			queryJson.setObj(result);
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
		return "jsonResult";
	}
	public String editWorkShopName(){
		long id =Long.parseLong(getHttpRequest().getParameter("workshop_id"));
		String name=getHttpRequest().getParameter("name");
		try {
			int result=workShopService.editWorkShopName(name,id);
			if(result==1){
				queryJson.setRetcode("1234");
			}
			if(result==-1){
				queryJson.setRetcode("1111");
				queryJson.setErrorMsg("车间名已经存在");
			}
			queryJson.setObj(result);
			} catch (ServiceException e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} catch (Exception e) {
				// TODO: handle exception
				queryJson.setRetcode("0003");
				queryJson.setErrorMsg("服务器连接异常");
				processException(e, queryJson);
			} 
		return "jsonResult";
	}
}
