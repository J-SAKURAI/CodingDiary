package com.huihuan.gmp.services.tool;

import org.springframework.stereotype.Service;
import com.huihuan.gmp.entity.Events;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import java.util.List;
import com.huihuan.gmp.vo.EventVo;
import java.sql.Timestamp;
@Service(value = "adenlerService")
public interface ICadenlerService  extends ICommService{
	public int addEvent(String title,int is_all_day,int repeating_type,String text,Timestamp start_time,Timestamp end_time)throws ServiceException;
	public int editEvent(long id, String title,int is_all_day,int repeating_type,String text,Timestamp start_time,Timestamp end_time)throws ServiceException;
	public int deleteEvent(long id)throws ServiceException;
	public List<EventVo> getEvents(Timestamp start_date,Timestamp end_date)throws ServiceException;
	public List<Events> getEventById(Long id) throws ServiceException;
}
