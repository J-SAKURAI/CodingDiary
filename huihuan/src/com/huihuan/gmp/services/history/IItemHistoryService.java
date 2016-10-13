package com.huihuan.gmp.services.history;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.huihuan.gmp.entity.Users;

public interface IItemHistoryService extends ICommService{
	public Map getItemHistoryList(String item_id, String table_name,String columns,String foreign_key_name) throws ServiceException;
	public Map getItemHistoryById(long id ,String table_name,String columns) throws ServiceException;
	public Map getTwoItemHistoryByIds(long id1,long id2 ,String table_name,String columns) throws ServiceException;
	public List<Users> getUserById(long id) throws ServiceException;
}
