package com.huihuan.gmp.services.buyManagement.impl;

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
import com.huihuan.gmp.entity.Company;
import com.huihuan.gmp.entity.Employees;
import com.huihuan.gmp.entity.Mails;
import com.huihuan.gmp.entity.ReceiveMails;
import com.huihuan.gmp.entity.Users;
import com.huihuan.gmp.services.buyManagement.ICompanyService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.mail.IMailService;
import com.huihuan.gmp.vo.ConstVo;
import com.huihuan.gmp.vo.MailsVo;
import com.huihuan.gmp.vo.ReceiveMailsVo;

@Service(value = "companyService")
public class CompanyServiceImpl extends CommServiceImpl implements ICompanyService {

	private Log log = LogFactory.getLog(CompanyServiceImpl.class);

	@Override
	public List<Company> getCompanies(String keyword) {
		// TODO Auto-generated method stub
		List list=baseDAO.findByHQL("from Company where coName like ?"
				,new Object[]{"%"+keyword+"%"});
		return list;
	}

	@Override
	public int deleteCompany(String id) {
		// TODO Auto-generated method stub
//		int i =baseDAO.executeSQL("delete from company where id=?"
//				,new Object[]{id});
		Company c=baseDAO.findById(Integer.parseInt(id), Company.class);
		baseDAO.delete(c);
		return 0;
	}
}
