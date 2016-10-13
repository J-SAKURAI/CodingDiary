package com.huihuan.gmp.services.buyManagement;

import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Company;
import com.huihuan.gmp.entity.Mails;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.MailsVo;

public interface ICompanyService extends ICommService {
	public List<Company> getCompanies(String keyword);
	
	public int deleteCompany(String id);
}
