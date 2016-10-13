package com.huihuan.gmp.actions.workShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.sf.json.JSONObject;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.OperationRooms;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.workShop.IOperationRoomService;
import com.huihuan.gmp.vo.OperationRoomsVo;
import com.huihuan.gmp.vo.SysPropotyVo;

import java.io.IOException;
import org.hibernate.Session;

public class OperationRoomAction extends BaseAction {

	private BaseJson queryJson =new BaseJson();
	@Resource
	IOperationRoomService operationRoomService;
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getOperationRoom()
	{
		queryJson =new BaseJson();
		try {	
			String queryPage = getHttpRequest().getParameter("queryPage");
			String productLinesWorkStepsId=getHttpRequest().getParameter("productLinesWorkStepsId");
			String pageSize = getHttpRequest().getParameter("pageSize");
			String orderPropoty=getHttpRequest().getParameter("orderPropoty");
			String orderType=getHttpRequest().getParameter("orderType");
			Map map = operationRoomService.getOperationRoom(queryPage,pageSize, productLinesWorkStepsId,orderPropoty,orderType);
			
			queryJson.setObj(map);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	
	public String getOperationRoomDetial(){
		queryJson = new BaseJson();
		try {
			String Id = getHttpRequest().getParameter("itemId");
			
			OperationRooms operationroom = operationRoomService.getOperationRoomDetial(Long.parseLong(Id));
			OperationRoomsVo vo = new OperationRoomsVo();
			
			vo.setId(operationroom.getId());
			vo.setName(operationroom.getName());
			vo.setSonRoom(operationroom.getSonRoom());
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
	
	public String editOperationRoom() {
		queryJson = new BaseJson();
		try {
			String id = getHttpRequest().getParameter("itemId");
			String sonRoom = getHttpRequest().getParameter("sonRoomValue");
			String name = getHttpRequest().getParameter("name");			
			int result = operationRoomService.editOperationRoom(id, name,Integer.parseInt(sonRoom));
			if(result==1)
			{
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("该车间已有该作业室！");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String addOperationRoom(){
		queryJson =new BaseJson();
		try{
			String productLinesWorkStepsId=getHttpRequest().getParameter("productLinesWorkStepsId");
			String sonRoom=getHttpRequest().getParameter("sonRoomValue");
			String name=getHttpRequest().getParameter("name");		
			int result=operationRoomService.addOperationRoom(productLinesWorkStepsId,name,sonRoom);
			if(result==1)
			{
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("该车间已有该作业室！");
			}
			}
			catch (ServiceException e) {
				// TODO: handle exception
				processException(e, queryJson);
			}
			return "jsonResult";
	}
	
	public String deleteOperationRoom(){		
		queryJson = new BaseJson();
		try {
			String id = getHttpRequest().getParameter("itemId");
			int result = operationRoomService.deleteOperationRoom(id);
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
