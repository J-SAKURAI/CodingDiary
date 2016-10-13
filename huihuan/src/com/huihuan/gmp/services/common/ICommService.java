package com.huihuan.gmp.services.common;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Catagories;

/**
 * 公共服务类 文件名稱：ICommService 描述：
 * 
 * @author Zhang Xiaofeng
 * @create 2012-4-11 汇环
 */
public interface ICommService {
	
	public <T> T getEntity(String id,Class<T> cls) throws ServiceException;
	
}
