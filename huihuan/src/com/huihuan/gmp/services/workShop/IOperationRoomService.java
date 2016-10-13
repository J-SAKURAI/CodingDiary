package com.huihuan.gmp.services.workShop;
import java.util.List;
import java.util.Map;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.OperationRooms;
import com.huihuan.gmp.services.common.ICommService;
public interface IOperationRoomService extends ICommService{
	public Map getOperationRoom(String queryPage,String size,String productLinesWorkStepsId,String orderPropoty,String orderType)throws ServiceException;
	public int editOperationRoom(String itemId,String name, int sonRoom) throws ServiceException;
	public int addOperationRoom(String productLinesWorkStepsId,String  name,String sonRoom) throws ServiceException;
	public int deleteOperationRoom(String id) throws ServiceException;
	public OperationRooms getOperationRoomDetial(Long id)throws ServiceException;
}