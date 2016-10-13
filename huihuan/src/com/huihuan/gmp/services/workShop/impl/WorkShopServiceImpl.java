package com.huihuan.gmp.services.workShop.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.huihuan.gmp.vo.CraftVo;
import com.huihuan.gmp.vo.WarehouseVo;
import com.huihuan.gmp.vo.WrkSpNodeVo;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.ProductionLines;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.workShop.IWorkShopService;
import com.huihuan.gmp.entity.Crafts;
import com.huihuan.gmp.entity.OperationRooms;
import com.huihuan.gmp.entity.Warehouses;
import com.huihuan.gmp.entity.WorkSteps;
import com.huihuan.gmp.entity.Workshops;
import com.huihuan.gmp.entity.ProductLinesWorkSteps;
@Service(value = "workShopService")
public class WorkShopServiceImpl extends CommServiceImpl implements IWorkShopService{

	@Override
	public long addWorkShop(String name) throws ServiceException{
		long id = -1;
		List<Workshops> wss=baseDAO.findByHQL("from Workshops where name=?", new Object[]{name});
		Workshops ws=new Workshops();
		if(wss.isEmpty()){
		ws.setName(name);
		baseDAO.save(ws);
		List<Workshops> w=baseDAO.findByHQL("from Workshops where name=?", new Object[]{name});		
		for(Workshops ww:w){
			id=ww.getId();
		}
		return id;
		}
		else{
			return -1;
		}
	}


	@Override
	public int addProductLine (long workShopId, long craftsId) throws ServiceException{
		List<ProductionLines> pls=baseDAO.findByHQL("from ProductionLines where workshops.id=? and crafts.id =?", new Object[]{workShopId,craftsId});
		if(pls.isEmpty()){
		ProductionLines pl=new ProductionLines();
		Workshops ws=baseDAO.findById(workShopId,Workshops.class);
		pl.setWorkshops(ws);
		Crafts c=baseDAO.findById(craftsId,Crafts.class);
		pl.setCrafts(c);
		baseDAO.save(pl);
		List<WorkSteps> wss=baseDAO.findByHQL("from WorkSteps where crafts.id =?", new Object[]{craftsId});
		for(WorkSteps ws0:wss){
			ProductLinesWorkSteps plws=new ProductLinesWorkSteps();
			plws.setProductionLines(pl);
			plws.setWorkSteps(ws0);
			baseDAO.save(plws);
		}
		return 0;}
		else{
			return 1;
		}
	}

	@Override
	public int deleteWorkShop (long workShopId) throws ServiceException{
		Workshops ws=baseDAO.findById(workShopId,Workshops.class);
		if(ws!=null){
			List<OperationRooms> ors=baseDAO.findAll(OperationRooms.class);
			boolean has_operation_room=false;
			for(OperationRooms or:ors){
				if(or.getProductLinesWorkSteps().getProductionLines().getWorkshops().getId()==workShopId){
					has_operation_room=true;
					break;
				}
			}
			if(has_operation_room){
				return 2;
			}else{
				
		Set<ProductionLines> pls=ws.getProductionLineses();
		for (ProductionLines pl:pls){
			Set<ProductLinesWorkSteps> plwss=pl.getProductLinesWorkStepses();
			for(ProductLinesWorkSteps plws:plwss){
				baseDAO.delete(plws);
			}
			baseDAO.delete(pl);
		}
		baseDAO.delete(ws);
		return 0;}}else
		{
			return 1;
		}
	}

	@Override
	public int deleteProductionLine (long productionLineId)
			throws ServiceException {
		ProductionLines pl=baseDAO.findById(productionLineId, ProductionLines.class);
		if(pl!=null){
			List<OperationRooms> ors=baseDAO.findAll(OperationRooms.class);
			boolean has_operation_room=false;
			for(OperationRooms or:ors){
				if(or.getProductLinesWorkSteps().getProductionLines().getId()==productionLineId){
					has_operation_room=true;
					break;
				}}
			if(has_operation_room){
				return 2;
			}else{
				Set<ProductLinesWorkSteps> plwss=pl.getProductLinesWorkStepses();
				for(ProductLinesWorkSteps plws:plwss){
					baseDAO.delete(plws);
				}
		baseDAO.delete(pl);
		return 0;}
		
		}else{
			return 1;
		}
	}

	@Override
	public int setWorkSteps (long productLine_workStepId,
			long wareHouseId, int aft_rcv_auto_invst, int self_picking,
			int rcv_dfct, int sign_in, int clear_area, int clear_area_tm_spc,
			int clear_area_tm_btch, int btch_rvw_mod, int btch_prd_sort_out,
			int wgh_rcv_mtrl, int wgh_ptin_mtrl, int wgh_mid_prd,
			int wgh_trn_out_mtrl, int mid_prd_lbl, int rcv_raw_mtrl_lbl,
			int rcv_pack_mtrl_lbl, int trn_t_mid_prd_lbl,
			int trn_t_rcv_prd_lbl, int put_in_mtrl_lbl) throws ServiceException {
			ProductLinesWorkSteps plws=baseDAO.findById(productLine_workStepId, ProductLinesWorkSteps.class);
			Warehouses wh=baseDAO.findById(wareHouseId, Warehouses.class);
			plws.setWarehouses(wh);
			plws.setAftRcvAutoInvst(aft_rcv_auto_invst);
			plws.setSelfPicking(self_picking);
			plws.setRcvDfct(rcv_dfct);
			plws.setSignIn(sign_in);
			
			plws.setClearArea(clear_area);
			plws.setClearAreaTmSpc(clear_area_tm_spc);
			plws.setClearAreaTmBtch(clear_area_tm_btch);
			plws.setBtchRvwMod(btch_rvw_mod);
			plws.setBtchPrdSortOut(btch_prd_sort_out);
			
			plws.setWghRcvMtrl(wgh_rcv_mtrl);
			plws.setWghPtinMtrl(wgh_ptin_mtrl);
			plws.setWghMidPrd(wgh_mid_prd);
			plws.setWghTrnOutMtrl(wgh_trn_out_mtrl);
			plws.setMidPrdLbl(mid_prd_lbl);
			
			plws.setRcvRawMtrlLbl(rcv_raw_mtrl_lbl);
			plws.setRcvPackMtrlLbl(rcv_pack_mtrl_lbl);
			plws.setTrnTMidPrdLbl(trn_t_mid_prd_lbl);
			plws.setTrnTRcvPrdLbl(trn_t_rcv_prd_lbl);
			plws.setPutInMtrlLbl(put_in_mtrl_lbl);
		    baseDAO.update(plws);
		
		
		
		return 0;
	}

	@Override
	public List<WrkSpNodeVo> getWorkShopTree() throws ServiceException {
		List<WrkSpNodeVo> tree=new ArrayList<WrkSpNodeVo>();
		List<Workshops> wss=baseDAO.findAll(Workshops.class);
		for(Workshops ws:wss){
			WrkSpNodeVo wsnv1=new WrkSpNodeVo();
			wsnv1.setId(ws.getId()*10+1);
			wsnv1.setLevel(1);
			wsnv1.setTextid(ws.getId());
			wsnv1.setName(ws.getName());
			wsnv1.setText(ws.getName());
			List<ProductionLines> pls=baseDAO.findByHQL("from ProductionLines where work_shop_id=?", new Object[]{ws.getId()});
			List<WrkSpNodeVo> wsnv2s=new ArrayList<WrkSpNodeVo>();
			for (ProductionLines pl:pls){
				WrkSpNodeVo wsnv2=new WrkSpNodeVo();
				wsnv2.setId(pl.getId()*10+2);
				wsnv2.setLevel(2);
				wsnv2.setTextid(pl.getId());
				wsnv2.setName(pl.getCrafts().getName());
				switch(pl.getCrafts().getSpecialType()){
				case 0:wsnv2.setType("普通");break;
				case 1:wsnv2.setType("预制品");break;
				case 2:wsnv2.setType("称量");break;
				case 3:wsnv2.setType("分装");break;
				case 4:wsnv2.setType("试生产");break;
				}
				wsnv2.setTypeid(pl.getCrafts().getSpecialType());
				String txt=pl.getCrafts().getName()+"("+wsnv2.getType()+")";
				wsnv2.setText(txt);
				List<ProductLinesWorkSteps> plwss=baseDAO.findByHQL("from ProductLinesWorkSteps where product_lines_id=?", new Object[]{pl.getId()});
				List<WrkSpNodeVo> wsnv3s=new ArrayList<WrkSpNodeVo>();
				for(ProductLinesWorkSteps plws:plwss){
					WrkSpNodeVo wsnv3=new WrkSpNodeVo();
					wsnv3.setId(plws.getId()*10+3);
					wsnv3.setLevel(3);
					wsnv3.setTextid(plws.getId());
					wsnv3.setName(plws.getWorkSteps().getName());
					wsnv3.setText(plws.getWorkSteps().getName());
					wsnv3.setChildren(null);
					wsnv3s.add(wsnv3);
				}
				wsnv2.setChildren(wsnv3s);
				wsnv2s.add(wsnv2);
			}
			wsnv1.setChildren(wsnv2s);
			tree.add(wsnv1);
		}
		return tree;
	}


	@Override
	public List<CraftVo> getWorkShopProductLines() throws ServiceException {
		List<Crafts> cs=baseDAO.findAll(Crafts.class);
		List<CraftVo> cvs=new ArrayList<CraftVo>();
		for(Crafts c:cs){
			CraftVo cv=new CraftVo();
			cv.setId(c.getId());
			cv.setName(c.getName());
			cv.setSpecialtype(c.getSpecialType());
			cvs.add(cv);
		}
		return cvs;
	}


	@Override
	public List<CraftVo> getcrafts_unseted(long workshopid) throws ServiceException {
		List<Crafts> cs=baseDAO.findAll(Crafts.class);
		List<ProductionLines> pls=baseDAO.findByHQL("from ProductionLines where work_shop_id=?", new Object[]{workshopid});
		List<CraftVo> cvs=new ArrayList<CraftVo>();
		for(Crafts c:cs){
			int num=0;
			for(ProductionLines pl:pls){
				if(c.getId()==pl.getCrafts().getId()){
					num++;
				}	
			}
			if(num==0){
				CraftVo cv=new CraftVo();
				cv.setId(c.getId());
				cv.setName(c.getName());
				cv.setSpecialtype(c.getSpecialType());
				cvs.add(cv);
			}
		}
		return cvs;
	}


	@Override
	public ProductLinesWorkSteps getworkstepsinformation(long plwsID)
			throws ServiceException {
		ProductLinesWorkSteps plws=baseDAO.findById(plwsID, ProductLinesWorkSteps.class);
		plws.setOperationRoomses(null);
		plws.setProductionLines(null);
		plws.setWorkSteps(null);
		return plws;
	}


	@Override
	public List<WarehouseVo> getMidWarehouses() throws ServiceException {
		List<Warehouses> whs=baseDAO.findByHQL("from Warehouses where type=4");
		List<WarehouseVo> whvs=new ArrayList<WarehouseVo>();
		for(Warehouses wh:whs){
			WarehouseVo whv=new WarehouseVo();
			whv.setId(wh.getId());
			whv.setName(wh.getName());
			whvs.add(whv);
		}
		return whvs;
	}
	
	@Override
	public int editWorkShopName(String name,long workshop_id)throws ServiceException{
		Workshops ws=baseDAO.findById(workshop_id, Workshops.class);
		
		if(!ws.getName().equals(name)){
			List<Workshops> wss=baseDAO.findByHQL("from Workshops where name=?", new Object[]{name});
			if(wss.isEmpty()){
				ws.setName(name);
				baseDAO.update(ws);
				return 0;
				}else{
					return -1;
					}
			}else {
			return 1;
		}
	};

}
