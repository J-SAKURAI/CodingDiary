package com.huihuan.gmp.actions.tool;

import javax.annotation.Resource;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.tool.ICadenlerService;
import com.huihuan.gmp.vo.EventVo;
import com.huihuan.gmp.entity.Events;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class CadenlerAction extends BaseAction{
@Resource
private ICadenlerService cadenlerService;
private BaseJson queryJson = new BaseJson();

public BaseJson getQueryJson() {
	return queryJson;
}

public void setQueryJson(BaseJson queryJson) {
	this.queryJson = queryJson;
}
public String addEvent(){
	queryJson = new BaseJson();
	String title=getHttpRequest().getParameter("title");
	String is_all_day=getHttpRequest().getParameter("is_all_day");
	String repeating_type=getHttpRequest().getParameter("repeating_type");
	String text=getHttpRequest().getParameter("text");
	String start_time=getHttpRequest().getParameter("start_time");
	String end_time=getHttpRequest().getParameter("end_time");
	try {
	int result=cadenlerService.addEvent(title, Integer.parseInt(is_all_day), Integer.parseInt(repeating_type), text, Timestamp.valueOf(start_time), Timestamp.valueOf(end_time));
	} catch (ServiceException e) {
		// TODO: handle exception
		queryJson.setRetcode("0003");
		queryJson.setErrorMsg("服务器连接异常");
		processException(e, queryJson);
	} catch (Exception e) {
		// TODO: handle exception
		queryJson.setRetcode("0003");
		queryJson.setErrorMsg("服务器连接异常");
		processException(e, queryJson);
	} 
	return "jsonResult";
}

public String editEvent(){
	queryJson = new BaseJson();
	long id =Long.parseLong(getHttpRequest().getParameter("id"));
	String title=getHttpRequest().getParameter("title");
	String is_all_day=getHttpRequest().getParameter("is_all_day");
	String repeating_type=getHttpRequest().getParameter("repeating_type");
	String text=getHttpRequest().getParameter("text");
	String start_time=getHttpRequest().getParameter("start_time");
	String end_time=getHttpRequest().getParameter("end_time");
	try {
	int result=cadenlerService.editEvent(id,title, Integer.parseInt(is_all_day), Integer.parseInt(repeating_type), text, Timestamp.valueOf(start_time), Timestamp.valueOf(end_time));
	} catch (ServiceException e) {
		// TODO: handle exception
		queryJson.setRetcode("0003");
		queryJson.setErrorMsg("服务器连接异常");
		processException(e, queryJson);
	} catch (Exception e) {
		// TODO: handle exception
		queryJson.setRetcode("0003");
		queryJson.setErrorMsg("服务器连接异常");
		processException(e, queryJson);
	} 
	return "jsonResult";
}
public String deleteEvent(){
	queryJson = new BaseJson();
	long id =Long.parseLong(getHttpRequest().getParameter("id"));
	try {
		int result=cadenlerService.deleteEvent(id);
		} catch (ServiceException e) {
			// TODO: handle exception
			queryJson.setRetcode("0003");
			queryJson.setErrorMsg("服务器连接异常");
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			queryJson.setRetcode("0003");
			queryJson.setErrorMsg("服务器连接异常");
			processException(e, queryJson);
		} 
		return "jsonResult";
}
public String getEvents(){
	queryJson = new BaseJson();
	String start_date=getHttpRequest().getParameter("start_date");
	String end_date=getHttpRequest().getParameter("end_date");
	List<EventVo> evs=new ArrayList<EventVo>();
			try {
				
				evs=cadenlerService.getEvents(Timestamp.valueOf(start_date), Timestamp.valueOf(end_date));
				} catch (ServiceException e) {
					// TODO: handle exception
					queryJson.setRetcode("0003");
					queryJson.setErrorMsg("服务器连接异常");
					processException(e, queryJson);
				} catch (Exception e) {
					// TODO: handle exception
					queryJson.setRetcode("0003");
					queryJson.setErrorMsg("服务器连接异常");
					processException(e, queryJson);
				} 
			queryJson.setObj(evs);
				return "jsonResult";
}
public String getEventById(){
	queryJson = new BaseJson();
	long id =Long.parseLong(getHttpRequest().getParameter("id"));
	List<Events> es=new ArrayList<Events>();
	try {
		es=cadenlerService.getEventById(id);
		} catch (ServiceException e) {
			// TODO: handle exception
			queryJson.setRetcode("0003");
			queryJson.setErrorMsg("服务器连接异常");
			processException(e, queryJson);
		} catch (Exception e) {
			// TODO: handle exception
			queryJson.setRetcode("0003");
			queryJson.setErrorMsg("服务器连接异常");
			processException(e, queryJson);
		} 
	queryJson.setObj(es);
		return "jsonResult";
}
}
