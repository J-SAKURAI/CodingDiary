package com.huihuan.gmp.services.tool.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Events;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.tool.ICadenlerService;
import com.huihuan.gmp.vo.EventVo;
import java.sql.Timestamp;

import org.springframework.stereotype.Service;
@Service(value = "cadenlerService")
public class CadenlerServiceImpl extends CommServiceImpl implements ICadenlerService {

	@Override
	public int addEvent(String title, int is_all_day, int repeating_type,
			String text, Timestamp start_time, Timestamp end_time)
			throws ServiceException {
		Events event=new Events();
		event.setIsAllDay(is_all_day);
		event.setRepeatingType(repeating_type);
		event.setTitle(title);
		event.setText(text);
		event.setStartTime(start_time);
		event.setEndTime(end_time);
		baseDAO.save(event);
		return 0;
	}

	@Override
	public int editEvent(long id,String title, int is_all_day,
			int repeating_type, String text, Timestamp start_time,
			Timestamp end_time) throws ServiceException {
		Events event=baseDAO.findById(id,Events.class);	
		event.setIsAllDay(is_all_day);
		event.setRepeatingType(repeating_type);
		event.setTitle(title);
		event.setText(text);
		event.setStartTime(start_time);
		event.setEndTime(end_time);
		baseDAO.update(event);
		return 0;
	}

	@Override
	public int deleteEvent(long id) throws ServiceException {
		Events event=baseDAO.findById(id,Events.class);
		baseDAO.delete(event);
		return 0;
	}

	@Override
	public List<EventVo> getEvents(Timestamp start_date, Timestamp end_date)
			throws ServiceException {
		List<Events> events=new ArrayList<Events>();
		events=baseDAO.findByHQL("from Events where start_time<? and end_time>? order by start_time", new Object[]{end_date,start_date});
		List<EventVo> eventvos=new ArrayList<EventVo>();
		for(Events event:events){
			EventVo eventvo=new EventVo();
			eventvo.setId(event.getId());
			eventvo.setStart_time(event.getStartTime());
			eventvo.setTitle(event.getTitle());
			eventvo.setEnd_time(event.getEndTime());
			Date date = new Date();   
	        try {   
	            date = event.getStartTime();   
	            String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};        

	            Calendar calendar = Calendar.getInstance();      

	            if(date != null){        

	                 calendar.setTime(date);      

	            }        

	            int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      

	            if (w < 0){        

	                w = 0;      

	            }  
	            eventvo.setWeek(weekOfDays[w]);
   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
	        eventvos.add(eventvo);
		}
		return eventvos;
	}

	@Override
	public List<Events> getEventById(Long id) throws ServiceException {
		List<Events> events=new ArrayList<Events>();
		Events event=baseDAO.findById(id,Events.class);
		event.setMailses(null);
		events.add(event);
		return events;
	}

}
