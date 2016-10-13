package com.huihuan.gmp.actions.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.cst.Constants;
import com.huihuan.gmp.entity.Mails;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.mail.IMailService;
import com.huihuan.gmp.services.baseSet.IConstService;
import com.huihuan.gmp.vo.ConstVo;
import com.huihuan.gmp.vo.MailsVo;

public class MailAction extends BaseAction {

	@Resource
	private IMailService mailService;

	private BaseJson queryJson = new BaseJson();

	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}

	public String sendMail() {
		queryJson = new BaseJson();
		try {
			Long send_person= Long.parseLong(getHttpRequest().getParameter("send_person"));
			String subject = getHttpRequest().getParameter("subject");
			String content = getHttpRequest().getParameter("content");
			
			String re = getHttpRequest().getParameter("receive_person");
			JSONArray jsonarray = JSONArray.fromObject(re);
			List receive_person= jsonarray;

			int result = mailService.sendMail(send_person,receive_person,subject,content);
			if (result == 0) {
				queryJson.setRetcode("0000");
			} else {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("发送失败！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}

	public String sendDraftMail() {
		queryJson = new BaseJson();
		try {
			Long mailid = Long.parseLong(getHttpRequest().getParameter("mailid"));
			Long send_person= Long.parseLong(getHttpRequest().getParameter("send_person"));
			String subject = getHttpRequest().getParameter("subject");
			String content = getHttpRequest().getParameter("content");
			
			String re = getHttpRequest().getParameter("receive_person");
			JSONArray jsonarray = JSONArray.fromObject(re);
			List receive_person= jsonarray;

			int result = mailService.sendDraftMail(mailid,send_person,receive_person,subject,content);
			if (result == 0) {
				queryJson.setRetcode("0000");
			} else {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("发送失败！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String saveMail() {
		queryJson = new BaseJson();
		try {
			Long send_person= Long.parseLong(getHttpRequest().getParameter("send_person"));
			String subject = getHttpRequest().getParameter("subject");
			String content = getHttpRequest().getParameter("content");
			
			String re = getHttpRequest().getParameter("receive_person");
			JSONArray jsonarray = JSONArray.fromObject(re);
			List receive_person= jsonarray;

			int result = mailService.saveMail(send_person,receive_person,subject,content);
			if (result == 0) {
				queryJson.setRetcode("0000");
			} else {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("发送失败！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}

	public String mailStatus() {
		queryJson = new BaseJson();
		HttpSession session = getHttpRequest().getSession(); 
		String idStr=session.getAttribute(Constants.USER_Id).toString();
		int userid = Integer.parseInt(idStr);
		long mailid = Long.parseLong(getHttpRequest().getParameter("mailId"));
		
		try {
			int result = mailService.changeStatus(mailid,userid);
			if (result == 0) {
				queryJson.setRetcode("0000");
			} else {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("状态修改失败！");
			}			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "jsonResult";
	}
	
	public String getMailsById() {
		Long id = Long.parseLong(getHttpRequest().getParameter("itemId"));
		MailsVo m=null;
		try {
			 m = mailService.FindMailById(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		queryJson.setObj(m);
		return "jsonResult";
	}

	/***
	 * 获得收件箱邮件
	 */
	public String selectReMails() {
		re_de_Mails(false);
		return "jsonResult";
	}

	/***
	 * 获得垃圾箱邮件
	 */
	public String selectDeleteMails() {
		re_de_Mails(true);
		return "jsonResult";
	}

	/****
	 * 获得发件箱邮件
	 */
	public String selectSendMails() {
		se_dr_Mails(false);
		return "jsonResult";
	}

	/****
	 * 获得草稿箱邮件
	 */
	public String selectDraftMails() {
		se_dr_Mails(true);
		return "jsonResult";
	}

	/***
	 * 收件箱和垃圾箱的公用函数部分 isdelete 是否是删除，即是否为垃圾箱
	 * 
	 * @param isdelete
	 */
	private void re_de_Mails(boolean isdelete) {
		int queryPage = Integer.parseInt(getHttpRequest().getParameter(
				"queryPage"));
		int pageSize = Integer.parseInt(getHttpRequest().getParameter(
				"pageSize"));
		String orderPropoty = getHttpRequest().getParameter("orderPropoty");
		String orderType = getHttpRequest().getParameter("orderType");
		int UserID = (Integer) getSession(Constants.USER_Id);
		Map result = mailService.selectRe_DeMailsByID(UserID, queryPage,
				pageSize, orderPropoty, orderType, isdelete);
		queryJson.setObj(result);
	}

	/***
	 * 草稿箱和发件箱箱的公用函数部分 isdelete 是否是删除，即是否为垃圾箱
	 * 
	 * @param isdraft
	 *            是否是草稿
	 */
	private void se_dr_Mails(boolean isdraft) {
		int queryPage = Integer.parseInt(getHttpRequest().getParameter(
				"queryPage"));
		int pageSize = Integer.parseInt(getHttpRequest().getParameter(
				"pageSize"));
		String orderPropoty = getHttpRequest().getParameter("orderPropoty");
		String orderType = getHttpRequest().getParameter("orderType");
		int UserID = (Integer) getSession(Constants.USER_Id);
		Map result = mailService.selectSe_DrMailsByID(UserID, queryPage,
				pageSize, orderPropoty, orderType, isdraft);
		queryJson.setObj(result);
	}

	/***
	 * 将收件箱的邮件删除 移到垃圾箱
	 */

	public String trashMail() {
		queryJson = new BaseJson();
		int result = 0;
		try{
		    String mails = getHttpRequest().getParameter("mails");
		    List mailList= JSONArray.fromObject(mails);		
		    int userId = (Integer) getSession(Constants.USER_Id);
			result = mailService.trashMail(mailList,userId);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		if (result == 1) {
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("该邮件不在收件箱中，无法删除！");
		}
		return "jsonResult";
	}
		
	public String restoreMail() {
		queryJson = new BaseJson();
		int result = 0;
		try{
		    String mails = getHttpRequest().getParameter("mails");
		    List mailList= JSONArray.fromObject(mails);		
		    int userId = (Integer) getSession(Constants.USER_Id);
			result = mailService.restoreMail(mailList,userId);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		if (result == 1) {
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("该邮件不在垃圾箱中，无法删除！");
		}
		return "jsonResult";
	}

	/***
	 * 将垃圾箱的邮件彻底删除
	 */
	public String deleteMail() {
		queryJson = new BaseJson();
		int result = 0;
		try{
		    String mails = getHttpRequest().getParameter("mails");
		    List mailList= JSONArray.fromObject(mails);		
		    int userId = (Integer) getSession(Constants.USER_Id);
			result = mailService.deleteMail(mailList,userId);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		if (result == 1) {
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("该邮件不在垃圾箱中，无法删除！");
		}
		return "jsonResult";
	}

	/***
	 * 将发件箱的邮件删除 （改变Mail的status）
	 */
	public String postedDelete() {
		queryJson = new BaseJson();
		int result = 0;
		try{
		    String mails = getHttpRequest().getParameter("mails");
		    List mailList= JSONArray.fromObject(mails);		
			result = mailService.postedDelete(mailList);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		if (result == 1) {
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("邮件已经执行过删除操作！");
		}
		return "jsonResult";
	}
	
	public String delComplete(){
		queryJson = new BaseJson();
		int result = 0;
		try{
		String mails = getHttpRequest().getParameter("mails");
		List mailList= JSONArray.fromObject(mails);		
		result = mailService.delComplete(mailList);
		}catch(Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		if (result == 1) {
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg("邮件已经执行过删除操作！");
		}
		return "jsonResult";
	}

}
