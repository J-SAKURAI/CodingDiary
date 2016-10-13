package com.huihuan.gmp.services.common.impl;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.daos.BaseDAO;
import com.huihuan.gmp.services.common.ICommService;

@Service(value="commService")
public class CommServiceImpl implements ICommService {

	private Log log = LogFactory.getLog(CommServiceImpl.class);

	@Resource
	protected BaseDAO baseDAO;

	@Override
	public <T> T getEntity(String id, Class<T> cls) throws ServiceException {
		// TODO Auto-generated method stub
		T t=baseDAO.findById(Long.parseLong(id), cls);
		return t;
	}
}
