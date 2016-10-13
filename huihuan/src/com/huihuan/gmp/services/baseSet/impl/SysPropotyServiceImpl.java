package com.huihuan.gmp.services.baseSet.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huihuan.common.util.DateUtil;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.SYS_PROPERTY;
import com.huihuan.gmp.daos.baseSet.SysPropotyDao;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.Const;
import com.huihuan.gmp.entity.FormulaMaterials;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.entity.Wrappers;
import com.huihuan.gmp.services.baseSet.ISysPropotyService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.vo.ConstVo;

@Service(value = "sysPropotyService")
public class SysPropotyServiceImpl extends CommServiceImpl implements ISysPropotyService {

	@Resource
	SysPropotyDao sysPropotyDao;

	@Override
	public Map getCodeTypes() throws ServiceException {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		String productCodeType="";
		String materialCodeType	="";
		String packageCodeType="";
		productCodeType=sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.PRODUCT_CODE_TYPE);
		materialCodeType=sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.MATERIAL_CODE_TYPE);
		packageCodeType=sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.PACKAGE_CODE_TYPE);
		map.put("productCodeType", productCodeType);
		map.put("materialCodeType", materialCodeType);
		map.put("packageCodeType", packageCodeType);
		return map;
	}

	@Override
	public int saveCodeTypes(String productCodeType, String materialCodeType,
			String packageCodeType) throws ServiceException {
		// TODO Auto-generated method stub
		sysPropotyDao.saveSysPropotyByKey(SYS_PROPERTY.PRODUCT_CODE_TYPE, productCodeType);
		sysPropotyDao.saveSysPropotyByKey(SYS_PROPERTY.MATERIAL_CODE_TYPE, materialCodeType);
		sysPropotyDao.saveSysPropotyByKey(SYS_PROPERTY.PACKAGE_CODE_TYPE, packageCodeType);
		return 0;
	}

	@Override
	public String getMachineCode()  throws ServiceException{
		// TODO Auto-generated method stub
		return sysPropotyDao.getAndIncSysPropotyByKey(SYS_PROPERTY.MACHINE_CODE);
	}
	
	public Map getSysPropotys(String queryPage,
			String size,String keyword,String orderPropoty,String orderType) throws ServiceException {
		// TODO Auto-generated method stub

		Map map = new HashMap();
		int offset = -1;
		int pageSize = 1;
		
		if (!StringUtil.isEmpty(size)) {
			pageSize = Integer.parseInt(size);
		}
		if (!StringUtil.isEmpty(queryPage)) {
			offset = (Integer.parseInt(queryPage) - 1) * pageSize;
		}
		
		String sql="select id as id,mdl_cd as mlCd,propoty_key as ky,propoty_vl as value,rmk as rmk " +
				"from sys_property ";
		
		List params=new ArrayList();
		if (keyword!=null&&!keyword.equals("")){
			sql+="where sys_property.propoty_key like ?";
			params.add("%" + keyword + "%");
		}
		if(!StringUtil.isBlank(orderPropoty)){
			sql+="order by "+orderPropoty+" "+orderType;
		}

		List resultList=baseDAO.findBySQLForVO(sql, ConstVo.class, params.toArray(), offset, pageSize);
		map.put("list", resultList);
		return map;
	}
	
	@Override
	public SysProperty getSysPropotysDetails(Long Id) throws ServiceException {
		SysProperty sysproperty = baseDAO.findById(Id, SysProperty.class);
		return sysproperty;

	}
	
	@Override
	public int deleteSysPropotyItem(String id) throws ServiceException{
		SysProperty sysproperty=baseDAO.findById(Long.parseLong(id), SysProperty.class);
		baseDAO.delete(sysproperty);
		return 0;
	}
	
	@Override
	public int addSysPropotyItem(String  mlCd,String ky, String value,String rmk) throws ServiceException
	{		
		SysProperty sysproperty=new SysProperty(mlCd,ky,value,rmk);
		baseDAO.save(sysproperty);
		return 0;
	}
	
	@Override
	public int editSysPropotyItem(String itemId,String  mlCd,String ky, String value,String rmk) throws ServiceException
	{
		SysProperty sysproperty=baseDAO.findById(Long.parseLong(itemId), SysProperty.class);
		if(!StringUtil.isEmpty(mlCd)){
			sysproperty.setMdlCd(mlCd);
		}
		if(!StringUtil.isEmpty(ky)){
			sysproperty.setPropotyKey(ky);
		}
		if(!StringUtil.isEmpty(value)){
			sysproperty.setPropotyVl(value);
		}
		if(!StringUtil.isEmpty(rmk)){
			sysproperty.setRmk(rmk);
		}
		baseDAO.save(sysproperty);
		return 0;
	}
	
}
