package com.huihuan.gmp.services.baseSet;

import java.util.List;
import java.util.Map;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.UnitVo;

public interface IUnitService extends ICommService{
	public List getUnits(String type) throws ServiceException;

	public List getQuantityUnit2ByQuantityUnit(String quantityUnitId) throws ServiceException;

	public List getBaseQuantityUnitByQuantityUnit(String quantityUnitId) throws ServiceException;
	
	public int addUnit(UnitVo vo) throws ServiceException;
	
	public int editUnit(UnitVo vo) throws ServiceException;
	
	public int deleteUnit(String id) throws ServiceException;
	
	public UnitVo getUnit(String id) throws ServiceException;
}
