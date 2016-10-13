package com.huihuan.gmp.services.baseSet;

import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.CatagoryVo;

public interface ICatagoryService extends ICommService{

	public Map getCodesLength(String type) throws ServiceException;

	public int saveCodesLength(String type,String bitLength,String sameCatagoryLength) throws ServiceException;

	public List getCatagoriesByType(int type) throws ServiceException;

	public List<CatagoryVo> getCatagoriesAndDetailsByType(int type) throws ServiceException;

	public List<Catagories> getUnSavedCatagoriesByType(int type) throws ServiceException;
	
	public int addCatagory(int type,String name,int length,String rmk) throws ServiceException;
	
	public int deleteCatagory(Long catagoryId) throws ServiceException;
	
	public int resetCatagory() throws ServiceException;
	
	public int editCatagory(Long catagoryId,String name,int length,String rmk) throws ServiceException;
	
	public List<CatagoryDetails> getCatagoryDetails(String catagoryId) throws ServiceException;
	
	public int addCatagoryDetail(Long catagoryId,String catagoryCd,String name) throws ServiceException;
	
	public int deleteCatagoryDetail(Long catagoryDetailId) throws ServiceException;
	
	public int editCatagoryDetail(Long catagoryDetailId,String catagoryCd,String name) throws ServiceException;

    public String getPropertyVl(String propotyKey)throws ServiceException;
    
    public Catagories getTypebyId(String catagoryId)throws ServiceException;


}

