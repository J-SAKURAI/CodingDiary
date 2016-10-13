package com.huihuan.gmp.actions.workShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.sf.json.JSONObject;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.AssemblyLines;
import com.huihuan.gmp.entity.OperationRooms;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.workShop.IAssemblyLinesService;
import com.huihuan.gmp.vo.AssemblyLinesVo;
import com.huihuan.gmp.vo.OperationRoomsVo;

import java.io.IOException;

public class AssemblyLinesAction extends BaseAction {

	private BaseJson queryJson =new BaseJson();
	@Resource
	IAssemblyLinesService assemblyLinesService;
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	//额外传进生产线ID，根据生产线找到其下流水线
	public String getAssemblyLines()
	{
		queryJson =new BaseJson();
		try {	
			String productLinesId = getHttpRequest().getParameter("productLinesId");
			String queryPage = getHttpRequest().getParameter("queryPage");
			String keyword=getHttpRequest().getParameter("keyword");
			String pageSize = getHttpRequest().getParameter("pageSize");
			String orderPropoty=getHttpRequest().getParameter("orderPropoty");
			String orderType=getHttpRequest().getParameter("orderType");
			
			Map map = assemblyLinesService.getAssemblyLines(productLinesId,queryPage,pageSize, keyword,orderPropoty,orderType);
			
			queryJson.setObj(map);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	
	public String getAssemblyLinesOperationRooms()
	{
		queryJson =new BaseJson();
		try {	
			String assemblyLinesId = getHttpRequest().getParameter("assemblyLinesId");		
			Map map = assemblyLinesService.getChosenAssemblyLinesOperationRooms(Long.parseLong(assemblyLinesId));			
			queryJson.setObj(map);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getAllOperationRooms()
	{
		queryJson =new BaseJson();
		try {	
			String productionLineId=getHttpRequest().getParameter("productionLineId");
			Map map = assemblyLinesService.getAllOperationRooms(productionLineId);			
			queryJson.setObj(map);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	
	public String setAssemblyLinesOperationRooms()
	{
		queryJson =new BaseJson();
		try {	
			String[] chosenList  = getHttpRequest().getParameterValues("ChosenList[]"); 
			String[] unChosenList  =  getHttpRequest().getParameterValues("notChosenList[]"); //getHttpRequest().getParameter("assemblyLinesId");		
			if(chosenList==null)
				{
				System.out.println("已选作业是列表为0");
				chosenList=new String[0];
				}
				
			if(unChosenList==null)
				{
				System.out.println("待选作业是列表为0");
				unChosenList=new String[0];
				
				}
			String assemblyLinesId = getHttpRequest().getParameter("assemblyLinesId");	
			int result = assemblyLinesService.setAssemblyLinesOperationRooms(chosenList,unChosenList,assemblyLinesId);			
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	
	public String ifAssemblyLines()
	{
		queryJson = new BaseJson();
		try {
			String Id = getHttpRequest().getParameter("product_lines_id");		
			int result = assemblyLinesService.ifAssemblyLines(Long.parseLong(Id));
			System.out.println(result);
			queryJson.setObj(result);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	public String getAssemblyLinesDetail(){
		queryJson = new BaseJson();
		try {
			String Id = getHttpRequest().getParameter("itemId");
			
			AssemblyLines assemblyLines = assemblyLinesService.getAssemblyLinesDetail(Long.parseLong(Id));
			AssemblyLinesVo vo = new AssemblyLinesVo();
			
			vo.setId(assemblyLines.getId());
			vo.setName(assemblyLines.getName());
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
	
	
	
	public String editAssemblyLines() {
		queryJson = new BaseJson();
		try {
			String id = getHttpRequest().getParameter("itemId");
			String name = getHttpRequest().getParameter("name");			
			int result = assemblyLinesService.editAssemblyLines(id, name);	
			if(result==1)
			{
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("该车间中已有该流水线！");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String addAssemblyLines(){
		queryJson =new BaseJson();
		try{
			String productLinesId=getHttpRequest().getParameter("productLinesId");
			String name=getHttpRequest().getParameter("name");		
			int result=assemblyLinesService.addAssemblyLines(productLinesId,name);
			if(result==1)
			{
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("该车间中已有该流水线！");
			}
			}
			catch (ServiceException e) {
				// TODO: handle exception
				processException(e, queryJson);
			}
			return "jsonResult";
	}
	
	public String deleteAssemblyLines(){		
		queryJson = new BaseJson();
		try {
			String id = getHttpRequest().getParameter("itemId");
			int result = assemblyLinesService.deleteAssemblyLines(id);
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
}
