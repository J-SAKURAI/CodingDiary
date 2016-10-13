package com.huihuan.gmp.actions.history;
import javax.annotation.Resource;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.history.IItemHistoryService;
import java.util.Map;
import com.huihuan.gmp.entity.Users;
import com.huihuan.gmp.vo.UserVo;
import java.util.List;
import java.util.ArrayList;

public class ItemHistoryAction extends BaseAction{
	@Resource
	private IItemHistoryService itemHistoryService;
	private BaseJson queryJson = new BaseJson();
	public BaseJson getQueryJson() {
		return queryJson;
	}
	
	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	public String getHistory() {
		queryJson = new BaseJson();
		String itemId =getHttpRequest().getParameter("itemId");
		String table_name =getHttpRequest().getParameter("table_name");
		String columns =getHttpRequest().getParameter("columns");
		String foreign_key_name=getHttpRequest().getParameter("foreign_key_name");
		try {
			Map map=itemHistoryService.getItemHistoryList(itemId,table_name,columns,foreign_key_name);
			queryJson.setObj(map);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "jsonResult";
	}
	
	public String getTwoHistoryDetail(){
		queryJson = new BaseJson();
		long id1 =  Long.parseLong(getHttpRequest().getParameter("id1"));
		long id2 =  Long.parseLong(getHttpRequest().getParameter("id2"));
		String table_name =getHttpRequest().getParameter("table_name");
		String columns =getHttpRequest().getParameter("columns");
		try {
			Map map=itemHistoryService.getTwoItemHistoryByIds(id1, id2, table_name, columns);
			queryJson.setObj(map);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return "jsonResult";
	}
	
	public String getHistoryById() {
		queryJson = new BaseJson();
		long id =  Long.parseLong(getHttpRequest().getParameter("id"));
		String table_name =getHttpRequest().getParameter("table_name");
		String columns =getHttpRequest().getParameter("columns");
		try {
			Map map=itemHistoryService.getItemHistoryById(id, table_name, columns);
			queryJson.setObj(map);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "jsonResult";
	}
	public String getUsersById(){
		queryJson = new BaseJson();
		long id =  Long.parseLong(getHttpRequest().getParameter("id"));
		List<Users> userlist=new ArrayList<Users>();
		List<UserVo> list=new ArrayList<UserVo>();
		try {
			 userlist =itemHistoryService.getUserById(id);
			 for(Users u:userlist){
				 UserVo uv=new UserVo();
				 uv.setUsername(u.getUsername());
				 uv.setName(u.getName());
				 list.add(uv);
			 }
			queryJson.setObj(list);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "jsonResult";
	}
}
