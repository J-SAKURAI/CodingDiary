package com.huihuan.gmp.services.baseSet;

import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.ProductVo;
import com.huihuan.gmp.vo.SameCatagoryVo;

public interface IProductService extends ICommService{
	
	public int isAbleAddProduct(String sameCatagoryId) throws ServiceException;
	
	public String getProductPreCode(String sameCatagoryId) throws ServiceException;
	
	public String getProductCodeLength() throws ServiceException;
	
	public Map getProducts(String catagoryDetails,String sameCatagoryId,String queryPage,String pageSize,String keyword,String status,String orderPropoty,String orderType) throws ServiceException;
	
	public int addProduct(ProductVo vo) throws ServiceException;
	
	public int deleteProduct(String id) throws ServiceException;
	
	public ProductVo getProduct(String id) throws ServiceException;
	
	public int checkProduct(String productId,String userId) throws ServiceException;
	
	public ProductVo getProductHsty(String id) throws ServiceException;
}
