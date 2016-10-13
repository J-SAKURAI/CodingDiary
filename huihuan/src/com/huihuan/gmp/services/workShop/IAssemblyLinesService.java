package com.huihuan.gmp.services.workShop;

import java.util.List;
import java.util.Map;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.AssemblyLines;
import com.huihuan.gmp.entity.OperationRooms;
import com.huihuan.gmp.services.common.ICommService;

public interface IAssemblyLinesService extends ICommService{

	public Map getAssemblyLines(String productLinesId,String queryPage,String size,String keyword,String orderPropoty,String orderType)throws ServiceException;
	public int editAssemblyLines(String itemId,String name) throws ServiceException;
	public int addAssemblyLines(String productLinesId,String  name) throws ServiceException;
	public int deleteAssemblyLines(String id) throws ServiceException;
	public Map getChosenAssemblyLinesOperationRooms(Long assemblyLinesId)throws ServiceException;
	public Map getAllOperationRooms(String productionLineId)throws ServiceException;
	public AssemblyLines getAssemblyLinesDetail(Long id)throws ServiceException;
	public int ifAssemblyLines(Long id)throws ServiceException;
	public int setAssemblyLinesOperationRooms(String[] chosenList,String[] unChosenList,String assemblyLinesId)throws ServiceException;
}