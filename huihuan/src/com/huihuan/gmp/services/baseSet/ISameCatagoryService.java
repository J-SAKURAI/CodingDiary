package com.huihuan.gmp.services.baseSet;

import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.SameCatagoryVo;

public interface ISameCatagoryService extends ICommService{
	
	public String getSameCatagoryLength() throws ServiceException;
	
	public SameCatagoryVo getSameCatagory(String id) throws ServiceException;
	
	public List getSameCatagories(String catagoryDetails,String keyword,String status,String orderPropoty,String orderType) throws ServiceException;
	
	public int addSameCatagory(SameCatagoryVo vo,String catagoryDetails) throws ServiceException;
	
	public int deleteSameCatagory(String id) throws ServiceException;
	
	public int editSameCatagory(SameCatagoryVo vo) throws ServiceException;
}
