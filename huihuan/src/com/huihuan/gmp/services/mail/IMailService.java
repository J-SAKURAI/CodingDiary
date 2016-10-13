package com.huihuan.gmp.services.mail;

import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Mails;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.MailsVo;

public interface IMailService extends ICommService {

public 	Map selectRe_DeMailsByID(int userID, int queryPage, int pageSize, String orderPropoty, String orderType, boolean isdelete);

public Map selectSe_DrMailsByID(int userID, int queryPage, int pageSize,
		String orderPropoty, String orderType, boolean isdraft);

public int trashMail(List mailList,int userId) throws ServiceException;

public int restoreMail(List mailList,int userId) throws ServiceException;

public int deleteMail(List mailList,int userId) throws ServiceException;

public int postedDelete(List mailList) throws ServiceException;

public int delComplete(List mailList)throws ServiceException;

public int sendMail(Long send_person, List receive_person,String subject,String content)throws ServiceException;
public int saveMail(Long send_person, List receive_person,String subject, String content)throws ServiceException;
public MailsVo FindMailById(Long id)throws ServiceException;

public int changeStatus(Long mailid,int userid)throws ServiceException;

public int sendDraftMail(Long mailid, Long send_person, List receive_person, String subject,	String content)throws ServiceException;
}
