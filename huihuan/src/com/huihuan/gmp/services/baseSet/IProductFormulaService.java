package com.huihuan.gmp.services.baseSet;

import java.util.List;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.*;
import com.huihuan.gmp.vo.*;
import com.huihuan.gmp.services.common.ICommService;


public interface IProductFormulaService extends ICommService{
	public List<ProductFormulaVo> getProductFormulaList(String[] catagoryDetails,String queryPage,String pageSize,String keyword,String status) throws ServiceException;
	public List<FormulasVo> getFormulasList(String id) throws ServiceException;
	public int deleteFormula(String id) throws ServiceException;
	public List<FormulaMaterials> getFormulasdetails(String id) throws ServiceException;
	public int deleteFormulaItem(String id) throws ServiceException;
	public FormulaMaterialsVo getFormulaItem(String id) throws ServiceException;
	public List<String> getFormulagroup(String id) throws ServiceException;

	//groupaction
	public int addGroup(GroupVo vo) throws ServiceException;
	public int editGroup(GroupVo vo) throws ServiceException;
	public int deleteGroup(String id) throws ServiceException;	
	public GroupVo getGroup(String id) throws ServiceException;
	public List getGroups() throws ServiceException;
	
	public int saveFormula(String id,String instruction,String convertion) throws ServiceException;
	public List<CatagoryVo> getCatagoriesAndDetailsByType(int type);
	public List<Products> getProductListById(String productDetails);
}
