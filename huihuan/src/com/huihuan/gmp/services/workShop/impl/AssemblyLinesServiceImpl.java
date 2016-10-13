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
import com.huihuan.gmp.daos.baseSet.SysPropotyDao;
import com.huihuan.gmp.services.baseSet.ISysPropotyService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.workShop.IAssemblyLinesService;
import com.huihuan.gmp.vo.AssemblyLinesOperationRoomsVo;
import com.huihuan.gmp.vo.AssemblyLinesVo;
import com.huihuan.gmp.vo.OperationRoomsVo;
import com.huihuan.gmp.vo.ProductLinesWorkStepsVo;
import com.huihuan.gmp.entity.AssemblyLines;
import com.huihuan.gmp.entity.AssemblyLinesOperationRooms;
import com.huihuan.gmp.entity.OperationRooms;
import com.huihuan.gmp.entity.ProductionLines;
import com.huihuan.gmp.entity.ProductLinesWorkSteps;
import com.huihuan.gmp.entity.Workshops;

@Service(value = "assemblyLinesService")
public class AssemblyLinesServiceImpl extends CommServiceImpl implements IAssemblyLinesService {
	
	//根据productLinesId获取该生产线下面的所有流水线
	public Map getAssemblyLines(String productLinesId,String queryPage,String size,String keyword,String orderPropoty,String orderType) throws ServiceException {
		Map map = new HashMap();
		int offset = -1;
		int pageSize = 1;
		
		if (!StringUtil.isEmpty(size)) {
			pageSize = Integer.parseInt(size);
		}
		if (!StringUtil.isEmpty(queryPage)) {
			offset = (Integer.parseInt(queryPage) - 1) * pageSize;
		}
		
		String sql="select id as id,name as name" +" from assembly_lines where product_lines_id= '"+productLinesId+"'";
		
		List params=new ArrayList();

		if(!StringUtil.isBlank(orderPropoty)){
			sql+="order by "+orderPropoty+" "+orderType;
		}

		List resultList=baseDAO.findBySQLForVO(sql, AssemblyLinesVo.class, params.toArray(), offset, pageSize);
		map.put("list", resultList);
		return map;
	}
	
	public Map getChosenAssemblyLinesOperationRooms(Long assemblyLinesId)throws ServiceException
	{
		Map map = new HashMap();
		String sql="select operation_rooms.name as name ,operation_rooms.id as id from assembly_lines_operation_rooms,operation_rooms where assembly_lines_id= '"+assemblyLinesId+"' and assembly_lines_operation_rooms.operation_rooms_id=operation_rooms.id";
		List params=new ArrayList();
		List resultList=baseDAO.findBySQLForVO(sql, OperationRoomsVo.class, params.toArray(), -1, 1000);
		
		AssemblyLines assemblyLines=baseDAO.findById(assemblyLinesId, AssemblyLines.class);
		ProductionLines productlines=assemblyLines.getProductionLines();
		Workshops workshops=productlines.getWorkshops();
		Long workshopsId=workshops.getId();
		sql="select operation_rooms.name as name ,operation_rooms.id as id from production_lines,operation_rooms,product_lines_work_steps where production_lines.id=product_lines_work_steps.product_lines_id and product_lines_work_steps.id=operation_rooms.prd_lns_wrk_stps_id and work_shop_id='"+workshopsId+"' and operation_rooms.status='0'";
		params=new ArrayList();
		List resultList2=baseDAO.findBySQLForVO(sql, AssemblyLinesVo.class, params.toArray(), -1, 10);
		
		map.put("list", resultList);
		map.put("list2", resultList2);
		return map;
	}
	
	public Map getAllOperationRooms(String productionLineId)throws ServiceException
	{
		Map map = new HashMap();
		
		String sql="select operation_rooms.name as name ,operation_rooms.id as id from operation_rooms,product_lines_work_steps where operation_rooms.prd_lns_wrk_stps_id=product_lines_work_steps.id and product_lines_work_steps.product_lines_id ='"+productionLineId+"'";
		List params=new ArrayList();
		List resultList=baseDAO.findBySQLForVO(sql, OperationRoomsVo.class, params.toArray(), -1, 10);	
		map.put("list", resultList);
		return map;
	}
	
	public int setAssemblyLinesOperationRooms(String[] chosenList,String[] unChosenList,String assemblyLinesId)throws ServiceException
	{
		for(int i=0;i<chosenList.length;i++)
		{			
			String sql="select id as id from assembly_lines_operation_rooms where assembly_lines_id='"+assemblyLinesId+"' and operation_rooms_id='"+chosenList[i]+"'";
			List params=new ArrayList();
			List resultList=baseDAO.findBySQLForVO(sql, AssemblyLinesVo.class, params.toArray(), -1, 10);
			if(resultList.size()==0)
			{
				OperationRooms operationrooms=baseDAO.findById(Long.parseLong(chosenList[i]), OperationRooms.class);
				operationrooms.setStatus(1);
				baseDAO.save(operationrooms);
				AssemblyLines assemblyLines = baseDAO.findById(Long.parseLong(assemblyLinesId), AssemblyLines.class);
				AssemblyLinesOperationRooms assemblyLinesOperationRooms=new AssemblyLinesOperationRooms();
				assemblyLinesOperationRooms.setOperationRooms(operationrooms);
				assemblyLinesOperationRooms.setAssemblyLines(assemblyLines);
				baseDAO.save(assemblyLinesOperationRooms);	
			}
	
		}
		
		for(int i=0;i<unChosenList.length;i++)
		{
			OperationRooms operationrooms=baseDAO.findById(Long.parseLong(unChosenList[i]), OperationRooms.class);
			operationrooms.setStatus(0);
			baseDAO.save(operationrooms);			
			String sql="delete from assembly_lines_operation_rooms where operation_rooms_id='"+unChosenList[i]+"'";
			baseDAO.executeSQL(sql);
		}	
		return 0;	
	}
	public int ifAssemblyLines(Long productLinesId) throws ServiceException
	{
		Map map = new HashMap();
		String sql="select id as id from product_lines_work_steps where product_lines_id= '"+productLinesId+"'";
		List params=new ArrayList();
		List resultList=baseDAO.findBySQLForVO(sql, ProductLinesWorkStepsVo.class, params.toArray(), -1, 1000);
		if(resultList.size()==0)return 0;
		for(int i=0;i<resultList.size();i++)
		{
			ProductLinesWorkStepsVo tmp=(ProductLinesWorkStepsVo)resultList.get(i);
			Long pid=tmp.getId();
			sql="select id as id from operation_rooms where prd_lns_wrk_stps_id= '"+pid+"'";
			params=new ArrayList();
			List resultList2=baseDAO.findBySQLForVO(sql, OperationRoomsVo.class, params.toArray(), -1, 1000);
			System.out.println(pid+"     "+resultList2.size());
			if(resultList2.size()==0) 
			{
				return 0;
			}
		}
		return 1;
	}
	
	public AssemblyLines getAssemblyLinesDetail(Long id)throws ServiceException
	{
		AssemblyLines assemblyLines = baseDAO.findById(id, AssemblyLines.class);
		return assemblyLines;
	}
	
	//修改作业室
	@Override
	public int editAssemblyLines(String itemId,String  name) throws ServiceException
	{		
		AssemblyLines assemblyLines=baseDAO.findById(Long.parseLong(itemId), AssemblyLines.class);
		ProductionLines productlines=assemblyLines.getProductionLines();
		Workshops workshops=productlines.getWorkshops();
		Long workshopsId=workshops.getId();
		String sql="select assembly_lines.name as name" +" from assembly_lines,production_lines where assembly_lines.product_lines_id=production_lines.id and work_shop_id='"+workshopsId+"' and name='"+name+"' and assembly_lines.id<>'"+itemId+"'";
		List params=new ArrayList();
		List resultList=baseDAO.findBySQLForVO(sql, AssemblyLinesVo.class, params.toArray(), -1, 10);
		if(!resultList.isEmpty())return 1;		
		if(!StringUtil.isEmpty(name)){
			assemblyLines.setName(name);
		}		
		baseDAO.save(assemblyLines);
		return 0;
	}
	
	@Override
	public int addAssemblyLines(String productLinesId,String  name) throws ServiceException
	{
		
		ProductionLines productlines=baseDAO.findById(Long.parseLong(productLinesId), ProductionLines.class);
		Workshops workshops=productlines.getWorkshops();
		Long workshopsId=workshops.getId();
		String sql="select assembly_lines.name as name" +" from assembly_lines,production_lines where assembly_lines.product_lines_id=production_lines.id and work_shop_id='"+workshopsId+"' and name='"+name+"'";
		List params=new ArrayList();
		List resultList=baseDAO.findBySQLForVO(sql, AssemblyLinesVo.class, params.toArray(), -1, 10);
		if(!resultList.isEmpty())return 1;	
		
		AssemblyLines assemblyLines=new AssemblyLines();
		assemblyLines.setName(name);
		assemblyLines.setProductionLines(productlines);
		baseDAO.save(assemblyLines);			
		return 0;
	}
	
	//删除作业室
	@Override
	public int deleteAssemblyLines(String id) throws ServiceException{
		AssemblyLines assemblyLines=baseDAO.findById(Long.parseLong(id), AssemblyLines.class);
		baseDAO.delete(assemblyLines);
		return 0;
	}
}