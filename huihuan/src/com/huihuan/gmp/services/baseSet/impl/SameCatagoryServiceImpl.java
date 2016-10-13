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
import com.huihuan.gmp.cst.SYS_PROPERTY;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.Products;
import com.huihuan.gmp.entity.SameCatagories;
import com.huihuan.gmp.entity.SameCatagorysDetails;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.services.baseSet.ICatagoryService;
import com.huihuan.gmp.services.baseSet.ISameCatagoryService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.vo.SameCatagoryVo;

@Service(value = "sameCatagoryService")
public class SameCatagoryServiceImpl extends CommServiceImpl implements
		ISameCatagoryService {

	private Log log = LogFactory.getLog(SameCatagoryServiceImpl.class);

	@Override
	public List getSameCatagories(String catagoryDetails,String keyword,String status,String orderPropoty,String orderType)
			throws ServiceException {
		// TODO Auto-generated method stub
		List resultList = new ArrayList();
		try {
			ObjectMapper mapper = new ObjectMapper();
			List<String> catagoryDetailList = mapper.readValue(catagoryDetails,
					List.class);
			String sql = "select DISTINCT "
					+ "same_catagories.id as id,"
					+ "CONCAT(same_catagories.CATAGORY_CODE,same_catagories.code) as code,"
					+ "same_catagories.name as name, "
					+ "same_catagories.status as status "
					//+ "CASE WHEN same_catagories.status = 0 THEN '有效' WHEN same_catagories.status = 1 THEN '无效' END as status "
					+ "from same_catagories "
					+ "left join same_catagorys_details on same_catagorys_details.SAME_CATAGORY_ID=same_catagories.ID "
					+ "where same_catagories.ID not in(select 0 ";
			List params = new ArrayList();
			for (String s : catagoryDetailList) {
				if (!StringUtil.isEmpty(s)) {
					// Long catagoryDetailId=Long.parseLong(s);
					// CatagoryDetails
					// catagoryDetails=baseDAO.findById(catagoryDetailId,
					// CatagoryDetails.class);
					sql += "union "
							+ "select SAME_CATAGORY_ID from same_catagorys_details ,catagory_details "
							+ "where same_catagorys_details.CATAGORY_DETAIL_ID=catagory_details.ID "
							+ "and catagory_details.CATAGORY_ID=(select CATAGORY_ID from catagory_details where ID=?) "
							+ "and CATAGORY_DETAIL_ID!=? ";
					params.add(s);
					params.add(s);
				}
			}
			sql += ") ";
			if(!StringUtil.isBlank(keyword)){
				sql+="and same_catagories.NAME like ?";
				params.add("%"+keyword+"%");
			}if(!StringUtil.isBlank(status)){
				sql+="and same_catagories.STATUS=?";
				params.add(status);
			}
			if(!StringUtil.isBlank(orderPropoty)){
				sql+="order by "+orderPropoty+" "+orderType;
			}
			resultList = baseDAO.findBySQLForVO(sql, SameCatagoryVo.class,
					params.toArray());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public int addSameCatagory(SameCatagoryVo vo, String catagoryDetails)
			throws ServiceException {
		// TODO Auto-generated method stub
		if(StringUtil.isBlank(vo.getName())){
			return 1;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			List<String> catagoryDetailList = mapper.readValue(catagoryDetails,
					List.class);
			List params = new ArrayList();
			String sql = "select * from same_catagorys_details,same_catagories "
					+ "where same_catagorys_details.SAME_CATAGORY_ID=same_catagories.ID " 
					+ "and same_catagories.name=? ";
			params.add(vo.getName());
			sql += "and SAME_CATAGORY_ID not in(select 0 ";
			for (String s : catagoryDetailList) {
				if (!StringUtil.isEmpty(s)) {
					// Long catagoryDetailId=Long.parseLong(s);
					// CatagoryDetails
					// catagoryDetails=baseDAO.findById(catagoryDetailId,
					// CatagoryDetails.class);
					sql += "union "
							+ "select SAME_CATAGORY_ID from same_catagorys_details ,catagory_details "
							+ "where same_catagorys_details.CATAGORY_DETAIL_ID=catagory_details.ID "
							+ "and catagory_details.CATAGORY_ID=(select CATAGORY_ID from catagory_details where ID=?) "
							+ "and CATAGORY_DETAIL_ID!=? ";
					params.add(s);
					params.add(s);
				}
			}
			sql += ")";
			if(baseDAO.getTotalSizeForSQL(sql, params.toArray())>0){
				return 3;
			}
			List catagoryList = baseDAO.findByProperty("type",
					CATAGORY_TYPE.PRODUCT, Catagories.class);
			if (catagoryList.size() != catagoryDetailList.size()) {
				return 2;
			}
			String catagoryCode = "";
			SameCatagories sameCatagory = new SameCatagories();
			sameCatagory.setCode(vo.getCode());
			sameCatagory.setName(vo.getName());
			sameCatagory.setStatus(Integer.parseInt(vo.getStatus()));
			sameCatagory.setUpdTm(DateUtil.getCurrentTime());
			for (String detailId : catagoryDetailList) {
				CatagoryDetails catagoryDetail = baseDAO.findById(
						Long.parseLong(detailId), CatagoryDetails.class);
				SameCatagorysDetails sameCatagorysDetail = new SameCatagorysDetails();
				sameCatagorysDetail.setCatagoryDetails(catagoryDetail);
				sameCatagorysDetail.setSameCatagories(sameCatagory);
				baseDAO.save(sameCatagorysDetail);
				catagoryCode += catagoryDetail.getCode();
			}
			sameCatagory.setCatagoryCode(catagoryCode);
			baseDAO.save(sameCatagory);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String getSameCatagoryLength() throws ServiceException {
		// TODO Auto-generated method stub
		String length = "";
		List<SysProperty> list = baseDAO.findByProperty("propotyKey",
				SYS_PROPERTY.SM_CTGRY_LNGTH, SysProperty.class);
		if (list.size() > 0) {
			SysProperty sysProperty = list.get(0);
			length = sysProperty.getPropotyVl();
		}
		return length;
	}

	@Override
	public int deleteSameCatagory(String id) throws ServiceException {
		// TODO Auto-generated method stub
		SameCatagories sameCatagory = baseDAO.findById(Long.parseLong(id),
				SameCatagories.class);
		if (sameCatagory != null) {
			if(sameCatagory.getProductses().size()>0){
				return 1;
			}
			for (Object obj : sameCatagory.getSameCatagorysDetailses()) {
				SameCatagorysDetails detail = (SameCatagorysDetails) obj;
				baseDAO.delete(detail);
			}
			baseDAO.delete(sameCatagory);
		}
		return 0;
	}

	@Override
	public SameCatagoryVo getSameCatagory(String id) throws ServiceException {
		// TODO Auto-generated method stub
		SameCatagoryVo vo = new SameCatagoryVo();
		SameCatagories sameCatagory = baseDAO.findById(Long.parseLong(id),
				SameCatagories.class);
		if (sameCatagory != null) {
			vo.setId(sameCatagory.getId() + "");
			vo.setCode(sameCatagory.getCatagoryCode() + sameCatagory.getCode());
			vo.setName(sameCatagory.getName());
			vo.setStatus(sameCatagory.getStatus() + "");
		}
		return vo;
	}

	@Override
	public int editSameCatagory(SameCatagoryVo vo) throws ServiceException {
		// TODO Auto-generated method stub
		if(StringUtil.isBlank(vo.getName())){
			return 1;
		}
		SameCatagories sameCatagory=baseDAO.findById(Long.parseLong(vo.getId()), SameCatagories.class);
		if (sameCatagory != null) {
			List params = new ArrayList();
			String sql="select same_catagorys_details.CATAGORY_DETAIL_ID from same_catagorys_details " +
					"where same_catagorys_details.SAME_CATAGORY_ID = ?";
			params.add(vo.getId());
			List<String> catagoryDetailList=baseDAO.findBySQL(sql, params.toArray());
			params.clear();
			sql = "select * from same_catagorys_details,same_catagories "
					+ "where same_catagorys_details.SAME_CATAGORY_ID=same_catagories.ID " 
					+ "and same_catagories.name=? and same_catagories.name!=? ";
			params.add(vo.getName());
			params.add(sameCatagory.getName());
			sql += "and SAME_CATAGORY_ID not in(select 0 ";
			for (Object s : catagoryDetailList) {
				if (!StringUtil.isEmpty(s+"")) {
					// Long catagoryDetailId=Long.parseLong(s);
					// CatagoryDetails
					// catagoryDetails=baseDAO.findById(catagoryDetailId,
					// CatagoryDetails.class);
					sql += "union "
							+ "select SAME_CATAGORY_ID from same_catagorys_details ,catagory_details "
							+ "where same_catagorys_details.CATAGORY_DETAIL_ID=catagory_details.ID "
							+ "and catagory_details.CATAGORY_ID=(select CATAGORY_ID from catagory_details where ID=?) "
							+ "and CATAGORY_DETAIL_ID!=? ";
					params.add(s);
					params.add(s);
				}
			}
			sql += ")";
			if(baseDAO.getTotalSizeForSQL(sql, params.toArray())>0){
				return 3;
			}
			sameCatagory.setName(vo.getName());
			sameCatagory.setStatus(Integer.parseInt(vo.getStatus()));
			baseDAO.update(sameCatagory);
		}
		return 0;
	}

}
