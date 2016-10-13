package com.huihuan.gmp.services.baseSet.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.huihuan.common.util.DateUtil;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.CATAGORY_TYPE;
import com.huihuan.gmp.cst.STATUS;
import com.huihuan.gmp.cst.SYS_PROPERTY;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.Const;
import com.huihuan.gmp.entity.Products;
import com.huihuan.gmp.entity.SameCatagories;
import com.huihuan.gmp.entity.SameCatagorysDetails;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.entity.Units;
import com.huihuan.gmp.services.baseSet.ICatagoryService;
import com.huihuan.gmp.services.baseSet.IConstService;
import com.huihuan.gmp.services.baseSet.IProductService;
import com.huihuan.gmp.services.baseSet.ISameCatagoryService;
import com.huihuan.gmp.services.baseSet.IUnitService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.vo.ConstVo;
import com.huihuan.gmp.vo.ProductVo;
import com.huihuan.gmp.vo.SameCatagoryVo;
import com.huihuan.gmp.vo.UnitVo;

@Service(value = "unitService")
public class UnitServiceImpl extends CommServiceImpl implements IUnitService {

	private Log log = LogFactory.getLog(UnitServiceImpl.class);

	@Override
	public List getUnits(String type) throws ServiceException {
		// TODO Auto-generated method stub
		String sql="";
		List<UnitVo> list=null;
		if(!StringUtil.isBlank(type)){
			sql="select id as id,name as name,type as type,proportion as proportion " +
					"from units where type=?";
			list=baseDAO.findBySQLForVO(sql, UnitVo.class, new Object[]{type});
		}else{
			sql="select id as id,name as name,type as type,proportion as proportion " +
					"from units";
			list=baseDAO.findBySQLForVO(sql, UnitVo.class, null);
		}
		return list;
	}

	@Override
	public List getQuantityUnit2ByQuantityUnit(String quantityUnitId)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<UnitVo> list=baseDAO.findBySQLForVO("select id as id,name as name from units where TYPE=(select type from units where id=?) and (TYPE!=4 or id=?)", 
				UnitVo.class, new Object[]{quantityUnitId,quantityUnitId});
		return list;
	}

	@Override
	public List getBaseQuantityUnitByQuantityUnit(String quantityUnitId)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<UnitVo> list=baseDAO.findBySQLForVO("select id as id,name as name from units where (TYPE!=(select type from units where id=?) or type=4) and id!=?", 
				UnitVo.class, new Object[]{quantityUnitId,quantityUnitId});
		return list;
	}


	@Override
	public int addUnit(UnitVo vo) throws ServiceException {
		// TODO Auto-generated method stub
		if(StringUtil.isBlank(vo.getName())){
			return 1;
		}
		List params=new ArrayList();
		params.add(vo.getName().trim());
		int count=baseDAO.getTotalSize("from Units where name=? and type=4",params.toArray());
		if(count>0){
			return 2;
		}
		Units unit=new Units();
		unit.setName(vo.getName().trim());
		unit.setType(4);
		baseDAO.save(unit);
		return 0;
	}

	@Override
	public int editUnit(UnitVo vo) throws ServiceException {
		// TODO Auto-generated method stub
		if(StringUtil.isBlank(vo.getName())){
			return 1;
		}
		Units unit=baseDAO.findById(Long.parseLong(vo.getId()), Units.class);
		List params=new ArrayList();
		params.add(vo.getName().trim());
		params.add(unit.getName());
		int count=baseDAO.getTotalSize("from Units where name=? and name!=? and type=4",params.toArray());
		if(count>0){
			return 2;
		}
		unit.setName(vo.getName().trim());
		baseDAO.save(unit);
		return 0;
	}

	@Override
	public int deleteUnit(String id) throws ServiceException {
		// TODO Auto-generated method stub
		Units unit=baseDAO.findById(Long.parseLong(id), Units.class);
		baseDAO.delete(unit);
		return 0;
	}

	@Override
	public UnitVo getUnit(String id) throws ServiceException {
		// TODO Auto-generated method stub
		Units unit=baseDAO.findById(Long.parseLong(id), Units.class);
		UnitVo vo=new UnitVo();
		vo.setId(unit.getId()+"");
		vo.setName(unit.getName());
		return vo;
	}
	
}
