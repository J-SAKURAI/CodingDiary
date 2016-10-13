package com.huihuan.gmp.services.history.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.history.IItemHistoryService;
import com.huihuan.gmp.entity.ProductsHsty;
import com.huihuan.gmp.entity.Users;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Service(value = "itemHistoryService")
public class ItemHistoryServiceImpl  extends CommServiceImpl implements IItemHistoryService{
	@Override 
	public Map getItemHistoryList(String item_id, String table_name,String columns,String foreign_key_name)throws ServiceException{
		String sql="select "+columns+" from "+table_name+" where "+foreign_key_name+" =? order by id";
		List list=baseDAO.findBySQL(sql, new Object[]{item_id});
		Map map=new HashMap();
		map.put("list",list);
		return map;
	}
	@Override
	public Map getItemHistoryById(long id,String table_name,String columns)throws ServiceException{
		String sql="select "+columns+" from "+table_name+" where id =? order by id";
		List list=baseDAO.findBySQL(sql, new Object[]{id});
		Map map=new HashMap();
		map.put("list",list);
		return map;
	}
	@Override
	public Map getTwoItemHistoryByIds(long id1,long id2 ,String table_name,String columns) throws ServiceException{
		String sql="select "+columns+" from "+table_name+" where id =? order by id";
		List list1=baseDAO.findBySQL(sql, new Object[]{id1});
		List list2=baseDAO.findBySQL(sql, new Object[]{id2});
		Map map=new HashMap();
		map.put("list1",list1);
		map.put("list2",list2);
		return map;
	};
	@Override
	public List<Users> getUserById(long id) throws ServiceException{
		List<Users> list = baseDAO
				.findByHQL("from Users where id=? order by id",new Object[]{id});

		return list;
	};
}
