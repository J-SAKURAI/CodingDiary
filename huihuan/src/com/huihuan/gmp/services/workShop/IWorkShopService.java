package com.huihuan.gmp.services.workShop;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.CraftVo;
import com.huihuan.gmp.vo.WarehouseVo;
import com.huihuan.gmp.vo.WrkSpNodeVo;

import java.util.ArrayList;
import java.util.List;

import com.huihuan.gmp.entity.Crafts;
import com.huihuan.gmp.entity.ProductLinesWorkSteps;
import com.huihuan.gmp.entity.ProductionLines;
import com.huihuan.gmp.entity.Warehouses;
public interface IWorkShopService extends ICommService{
	public long addWorkShop(String name ) throws ServiceException;
	public List<CraftVo> getWorkShopProductLines()throws ServiceException;
	public int addProductLine(long workShopId,long craftsId )throws ServiceException;
	public int deleteWorkShop(long workShopId)throws ServiceException;
	public int deleteProductionLine(long productionLineId)throws ServiceException;
	public int setWorkSteps (long productLine_workStepId ,long wareHouseId, int aft_rcv_auto_invst,
			int self_picking ,int rcv_dfct,int sign_in,int clear_area,int clear_area_tm_spc,
			int clear_area_tm_btch,int btch_rvw_mod,int btch_prd_sort_out ,int wgh_rcv_mtrl,int wgh_ptin_mtrl,
			int wgh_mid_prd,int wgh_trn_out_mtrl,int mid_prd_lbl,int rcv_raw_mtrl_lbl,int rcv_pack_mtrl_lbl,
			int trn_t_mid_prd_lbl,int trn_t_rcv_prd_lbl,int put_in_mtrl_lbl)throws ServiceException;
	public List<WrkSpNodeVo> getWorkShopTree()throws ServiceException;
	public List<CraftVo> getcrafts_unseted( long workshopid)throws ServiceException;
	public ProductLinesWorkSteps getworkstepsinformation( long plwsID)throws ServiceException;
	public List<WarehouseVo> getMidWarehouses() throws ServiceException;
	public int editWorkShopName(String name,long workshop_id)throws ServiceException;
}