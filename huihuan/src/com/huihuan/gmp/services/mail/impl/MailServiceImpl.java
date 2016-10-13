package com.huihuan.gmp.services.mail.impl;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;

import com.huihuan.common.util.StringUtil;
//import com.huihuan.gmp.actions.mail.K;
//import com.huihuan.gmp.actions.mail.V;
import com.huihuan.gmp.daos.BaseDAO;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Employees;
import com.huihuan.gmp.entity.Mails;
import com.huihuan.gmp.entity.ReceiveMails;
import com.huihuan.gmp.entity.Users;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.mail.IMailService;
import com.huihuan.gmp.vo.ConstVo;
import com.huihuan.gmp.vo.MailsVo;
import com.huihuan.gmp.vo.ReceiveMailsVo;

@Service(value = "mailService")
public class MailServiceImpl extends CommServiceImpl implements IMailService {

	private Log log = LogFactory.getLog(MailServiceImpl.class);
	public int sendMail(Long send_person, List receive_person,String subject,String content) {
		// TODO Auto-generated method stub
		Mails mail = new Mails();
		Users users=new Users();
		Date date = new Date();
		
		users=baseDAO.findById(send_person, Users.class);
		mail.setUsers(users);
		mail.setSubject(subject);
		mail.setContent(content);
		mail.setType(1);//0草稿1已发送
		mail.setEvents(null);
		Timestamp nowdate = new Timestamp(date.getTime());
		mail.setCrtTm(nowdate);
		baseDAO.save(mail);

		for(Object item:receive_person){
			ReceiveMails rmail = new ReceiveMails();
			long id=Long.parseLong((String)item);
			rmail.setMails(mail);
			users=baseDAO.findById(id, Users.class);
			rmail.setUsers(users);
			rmail.setStatus(0);//0未读1已读-1已删除
			baseDAO.save(rmail);
		}
		return 0;
	}
	
	public int sendDraftMail(Long mailid,Long send_person,List receive_person,String subject,String content){
		// TODO Auto-generated method stub
		Mails mail = new Mails();
		Users users=new Users();
		Date date = new Date();
		
		users=baseDAO.findById(send_person, Users.class);
		mail.setUsers(users);
		mail.setSubject(subject);
		mail.setContent(content);
		mail.setType(1);//0草稿1已发送
		mail.setEvents(null);
		Timestamp nowdate = new Timestamp(date.getTime());
		mail.setCrtTm(nowdate);
		baseDAO.save(mail);

		for(Object item:receive_person){
			ReceiveMails rmail = new ReceiveMails();
			long id=Long.parseLong(item.toString());
			rmail.setMails(mail);
			users=baseDAO.findById(id, Users.class);
			rmail.setUsers(users);
			rmail.setStatus(0);//0未读1已读-1已删除
			baseDAO.save(rmail);
		}
		String sql = "delete from receive_mails" +
					" where MAIL_ID = "+mailid;
		baseDAO.executeSQL(sql);
		sql = "delete from mails" +
			  " where ID = "+mailid;
		baseDAO.executeSQL(sql);
		
		return 0;
	}
	
	public int saveMail(Long send_person, List receive_person,String subject,String content) {
		// TODO Auto-generated method stub
		Mails mail = new Mails();
		Users users=new Users();
		Date date = new Date();
		users=baseDAO.findById(send_person, Users.class);
		mail.setUsers(users);
		mail.setSubject(subject);
		mail.setContent(content);
		mail.setType(0);//0草稿1已发送
		mail.setEvents(null);
		Timestamp nowdate = new Timestamp(date.getTime());
		mail.setCrtTm(nowdate);
		baseDAO.save(mail);

		for(Object item:receive_person){
			ReceiveMails rmail = new ReceiveMails();
			long id=Long.parseLong((String)item);
			rmail.setMails(mail);
			users=baseDAO.findById(id, Users.class);
			rmail.setUsers(users);
			rmail.setStatus(0);//0未读1已读-1已删除
			baseDAO.save(rmail);
		}
		return 0;
	}
	public int changeStatus(Long mailid,int userid)throws ServiceException{
		String sql ="select ID" +
				" from receive_mails" +
				" where RECEIVE_ID	= '"+userid+"'" +
				" and MAIL_ID= '"+mailid+"'";
		List idlist=baseDAO.findBySQL(sql, null);
		long remailid = Long.parseLong(idlist.get(0).toString());
		ReceiveMails rm = baseDAO.findById(remailid, ReceiveMails.class);
		int s=rm.getStatus();
		if(s==0){
			rm.setStatus(1);
		}
		baseDAO.save(rm);
		
		return 0;
	}
	public MailsVo FindMailById(Long id){
		Mails mail = new Mails();
		mail = baseDAO.findById(id, Mails.class);
		return new MailsVo(mail);
	}

	/***
	 * 获取删除的收件或者未删除的收件
	 * 
	 * @param userID
	 * @param queryPage
	 * @param pageSize
	 * @param orderPropoty
	 * @param orderType
	 * @param isdelete
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectRe_DeMailsByID(int userID, int queryPage,
			int pageSize, final String orderPropoty, String orderType,
			boolean isdelete) {
		List<MailsVo> ResultList = new ArrayList<MailsVo>();
		Map<String, Object> map = new HashMap<String, Object>();
		// List list =
		// baseDAO.findBySQLForVO("select * from Receive_Mails where RECEIVE_ID=?",ReceiveMailsVo.class,new
		// Object[]{userID});
		String hql = "from ReceiveMails where RECEIVE_ID=? ";
		if (isdelete) {//0未读1已读-1已删除（在垃圾箱中） 2：彻底删除
			hql += "	and status = -1";
		} else {
			hql += "	and status != -1 and status != 2";
		}
		List<ReceiveMails> list = baseDAO.findByHQL(hql,
				new Object[] { userID });

		// list = baseDAO.findByPage(hql, userID, startitem, pageSize);
		for (ReceiveMails tmp : list) {
			if(tmp.getMails().getType()==0)continue;//如果是对方未发送信件（草稿）就不放人收件箱
			MailsVo mailsvo = new MailsVo(tmp.getMails());
			mailsvo.setStatus(tmp.getStatus());
			//收件箱和草稿箱，只需要获取当前一条receivemailsID
			ResultList.add(mailsvo);
		}
		// 由于字段不在一张表，所以只能结果进行排序；
		final int order = orderType.equals("") ? 1 : -1;
		if (!orderPropoty.equals(""))
			Collections.sort(ResultList, new Comparator<Object>() {
				@Override
				public int compare(Object o1, Object o2) {
					if (orderPropoty.equals("crtTm"))
						return order
								* ((MailsVo) o1).getCrtTm().compareTo(
										((MailsVo) o2).getCrtTm());
					else if (orderPropoty.equals("status"))
						return order
								* (((MailsVo) o1).getStatus() - ((MailsVo) o2)
										.getStatus());
					else
						return order
								* ((MailsVo) o1).getSubject().compareTo(
										((MailsVo) o2).getSubject());
				}
			});
		int fromIndex = (queryPage - 1) * pageSize;
		int toIndex = Math.min((queryPage - 1) * pageSize + pageSize,
				ResultList.size());
		map.put("totalSize", ResultList.size());
		map.put("list", ResultList.subList(fromIndex, toIndex));
		return map;
	}

	@Override
	public Map selectSe_DrMailsByID(int userID, int queryPage, int pageSize,
			String orderPropoty, String orderType, boolean isdraft) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Mails where SEND_ID=? ";

		if (isdraft) {//0草稿1已发送 2:已删除(发件箱中彻底 草稿箱删除 均不显示在垃圾箱)
			hql += "	and type = 0";
		} else {
			hql += "	and type = 1";
		}
		if (!orderPropoty.equals(""))
			hql += " ORDER BY " + orderPropoty + " 	" + orderType;
		List<Mails> list = baseDAO.findByHQL(hql, new Object[] { userID });
		map.put("totalSize", list.size());
		list = baseDAO.findByPage(hql, new Object[] { userID }, (queryPage - 1)
				* pageSize, pageSize);
		List<MailsVo> ResultList = new ArrayList();
		for (Mails tmp : list) {
			MailsVo mailsvo = new MailsVo(tmp);
			if (isdraft) {
				mailsvo.setStatus(3);// 未发送
			} else {
				mailsvo.setStatus(2);// 已发送
			}

			ResultList.add(mailsvo);
		}
		map.put("list", ResultList);
		return map;
	}

	
	/**
	 * ReceiveMails status  -1： 已删除（在垃圾箱中）   0 ：未读（在收件箱中）  1：已读（在收件箱中） 2：彻底删除
	**/
	public int trashMail(List mailList,int userId) throws ServiceException {
		// TODO Auto-generated method stub
		for(Object item:mailList){
	        Mails mail = new Mails();
			Long id=Long.parseLong((String)item);
		    List<ReceiveMails> list = baseDAO.findByHQL("from ReceiveMails where RECEIVE_ID=? and MAIL_ID=?",
				new Object[] { userId,id });
		    ReceiveMails receiveMail=new ReceiveMails();
		    receiveMail=list.get(0);
			int oldStatus =  receiveMail.getStatus();
			if (oldStatus == 0 || oldStatus == 1)
			{
				receiveMail.setStatus(-1);
				baseDAO.update(receiveMail);
			}
			else
				return 1;
			}		
		return 0;
	}
	
	/**
	 * ReceiveMails status -1： 已删除（在垃圾箱中）   0 ：未读（在收件箱中）  1：已读（在收件箱中） 2：彻底删除
	**/
	public int deleteMail(List mailList,int userId) throws ServiceException {
		// TODO Auto-generated method stub
		for(Object item:mailList){
	        Mails mail = new Mails();
			Long id=Long.parseLong((String)item);
		    List<ReceiveMails> list = baseDAO.findByHQL("from ReceiveMails where RECEIVE_ID=? and MAIL_ID=?",
				new Object[] { userId,id });
		    ReceiveMails receiveMail=new ReceiveMails();
		    receiveMail=list.get(0);
			int oldStatus =  receiveMail.getStatus();
			if (oldStatus == -1)
			{
				receiveMail.setStatus(2);
				baseDAO.update(receiveMail);
			}
			else
				return 1;
			}		
		return 0;
	}
	/**从收件箱中还原
	 * ReceiveMails status -1： 已删除（在垃圾箱中）   0 ：未读（在收件箱中）  1：已读（在收件箱中） 2：彻底删除
	**/
	public int restoreMail(List mailList,int userId) throws ServiceException {
		// TODO Auto-generated method stub
		for(Object item:mailList){
	        Mails mail = new Mails();
			Long id=Long.parseLong((String)item);
		    List<ReceiveMails> list = baseDAO.findByHQL("from ReceiveMails where RECEIVE_ID=? and MAIL_ID=?",
				new Object[] { userId,id });
		    ReceiveMails receiveMail=new ReceiveMails();
		    receiveMail=list.get(0);
			int oldStatus =  receiveMail.getStatus();
			if (oldStatus == -1)
			{
				receiveMail.setStatus(1);
				baseDAO.update(receiveMail);
			}
			else
				return 1;
			}		
		return 0;
	}
	/**
	 * Mails type  0 ：草稿   1：已发送  2:已删除(发送成功后删除 ：发件箱中彻底删除)
	**/
	public int postedDelete(List mailList)throws ServiceException{
		for(Object item:mailList){
			Mails mail = new Mails();
			Long id=Long.parseLong((String)item);
			mail = baseDAO.findById(id, Mails.class);
			int oldType = mail.getType();
			if (oldType == 1)
				mail.setType(2);
			else
				return 1;
			baseDAO.update(mail);
		}
	    return 0;
	}

	/**
	 * Mails type  0 ：草稿   1：已发送  2:已删除(草稿箱中彻底删除)
	**/
   public int delComplete(List mailList)throws ServiceException{
		for(Object item:mailList){
			Mails mail = new Mails();
			long id=Long.parseLong((String)item);
			mail = baseDAO.findById(id, Mails.class);
			int oldType = mail.getType();
			if (oldType == 0)
				mail.setType(2);
			else
				return 1;
			baseDAO.update(mail);
		}
	    return 0;
    }
}
