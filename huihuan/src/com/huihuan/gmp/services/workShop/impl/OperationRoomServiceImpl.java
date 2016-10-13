package com.huihuan.gmp.services.workShop.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huihuan.common.util.DateUtil;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.SYS_PROPERTY;
import com.huihuan.gmp.daos.baseSet.SysPropotyDao;
import com.huihuan.gmp.services.baseSet.ISysPropotyService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.workShop.IOperationRoomService;
import com.huihuan.gmp.vo.AssemblyLinesVo;
import com.huihuan.gmp.vo.ConstVo;
import com.huihuan.gmp.vo.OperationRoomsVo;
import com.huihuan.gmp.vo.ProductLinesWorkStepsVo;
import com.huihuan.gmp.entity.AssemblyLines;
import com.huihuan.gmp.entity.OperationRooms;
import com.huihuan.gmp.entity.ProductLinesWorkSteps;
import com.huihuan.gmp.entity.ProductionLines;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.entity.Workshops;

@Service(value = "operationRoomService")
public class OperationRoomServiceImpl extends CommServiceImpl implements IOperationRoomService {
	
	//获取所有作业室
	public Map getOperationRoom(String queryPage,String size,String productLinesWorkStepsId,String orderPropoty,String orderType) throws ServiceException {
		Map map = new HashMap();
		int offset = -1;
		int pageSize = 1;
		
		if (!StringUtil.isEmpty(size)) {
			pageSize = Integer.parseInt(size);
		}
		if (!StringUtil.isEmpty(queryPage)) {
			offset = (Integer.parseInt(queryPage) - 1) * pageSize;
		}
		
		String sql="select id as id,name as name ,son_room as sonRoom " +" from operation_rooms  where prd_lns_wrk_stps_id= '"+productLinesWorkStepsId+"'";
		List params=new ArrayList();

		if(!StringUtil.isBlank(orderPropoty)){
			sql+="order by "+orderPropoty+" "+orderType;
		}
		List resultList=baseDAO.findBySQLForVO(sql, OperationRoomsVo.class, params.toArray(), offset, pageSize);
		
		map.put("list", resultList);
		return map;
	}
	
	//修改作业室
	@Override
	public int editOperationRoom(String itemId,String  name,int sonRoom) throws ServiceException
	{
		
		OperationRooms operationrooms=baseDAO.findById(Long.parseLong(itemId), OperationRooms.class);
		ProductLinesWorkSteps productLinesWorkSteps=operationrooms.getProductLinesWorkSteps();	
		ProductionLines productlines=productLinesWorkSteps.getProductionLines();
		Workshops workshops=productlines.getWorkshops();
		Long workshopsId=workshops.getId();
		String sql="select operation_rooms.name as name" +" from operation_rooms,product_lines_work_steps,production_lines where product_lines_work_steps.product_lines_id=production_lines.id and operation_rooms.prd_lns_wrk_stps_id=product_lines_work_steps.id and work_shop_id='"+workshopsId+"' and name='"+name+"' and operation_rooms.id<>'"+itemId+"'";
		List params=new ArrayList();
		List resultList=baseDAO.findBySQLForVO(sql, AssemblyLinesVo.class, params.toArray(), -1, 10);
		if(!resultList.isEmpty())return 1;	
		
		if(!StringUtil.isEmpty(name)){
			operationrooms.setName(name);
		}
		if(sonRoom!=-1)
		{
			operationrooms.setSonRoom(sonRoom);
		}

		baseDAO.save(operationrooms);
		
		
		return 0;
	}
	public OperationRooms getOperationRoomDetial(Long id) throws ServiceException{
		OperationRooms operationRoom = baseDAO.findById(id, OperationRooms.class);
		return operationRoom;
	}
	@Override
	public int addOperationRoom(String pID,String  name,String sonRoom) throws ServiceException
	{	
		ProductLinesWorkSteps productLinesWorkSteps=baseDAO.findById(Long.parseLong(pID), ProductLinesWorkSteps.class);	
		ProductionLines productlines=productLinesWorkSteps.getProductionLines();
		Workshops workshops=productlines.getWorkshops();
		Long workshopsId=workshops.getId();
		String sql="select operation_rooms.name as name" +" from operation_rooms,product_lines_work_steps,production_lines where product_lines_work_steps.product_lines_id=production_lines.id and operation_rooms.prd_lns_wrk_stps_id=product_lines_work_steps.id and work_shop_id='"+workshopsId+"' and name='"+name+"'";
		List params=new ArrayList();
		List resultList=baseDAO.findBySQLForVO(sql, AssemblyLinesVo.class, params.toArray(), -1, 10);
		if(!resultList.isEmpty())return 1;	
		
		OperationRooms operationRooms=new OperationRooms();
		operationRooms.setName(name);
		operationRooms.setProductLinesWorkSteps(productLinesWorkSteps);
		operationRooms.setSonRoom(Integer.parseInt(sonRoom));
		operationRooms.setStatus(0);
		baseDAO.save(operationRooms);
		
		return 0;
	}
	
	//删除作业室
	@Override
	public int deleteOperationRoom(String id) throws ServiceException{
		OperationRooms operationrooms=baseDAO.findById(Long.parseLong(id), OperationRooms.class);
		baseDAO.delete(operationrooms);
		return 0;
	}
}