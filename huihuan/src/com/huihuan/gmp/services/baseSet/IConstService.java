package com.huihuan.gmp.services.baseSet;

import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.ConstVo;

public interface IConstService extends ICommService{
	public List getConsts(String mlCd,String type) throws ServiceException;
	
	public int addConst(ConstVo vo) throws ServiceException;
	
	public int editConst(String id,ConstVo vo) throws ServiceException;
	
	public int deleteConst(String id) throws ServiceException;
	
	public ConstVo getConst(String id) throws ServiceException;
	
	public List getUnits(String type) throws ServiceException;
	public Map searchConsts(int queryPage,int size,String keyword ,String orderPropoty,String orderType)  throws ServiceException;
}
