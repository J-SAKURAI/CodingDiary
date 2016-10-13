package com.huihuan.gmp.services.baseSet.impl;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import antlr.StringUtils;

import com.huihuan.common.util.DateUtil;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.SYS_PROPERTY;
import com.huihuan.gmp.daos.baseSet.SysPropotyDao;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.Products;
import com.huihuan.gmp.entity.SysProperty;
import com.huihuan.gmp.services.baseSet.ICatagoryService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.CatagoryVo;
import com.sun.org.apache.commons.beanutils.BeanUtils;

@Service(value="catagoryService")
public class CatagoryServiceImpl extends CommServiceImpl implements ICatagoryService {

	private Log log = LogFactory.getLog(CatagoryServiceImpl.class);
	
	@Resource
	SysPropotyDao sysPropotyDao;
	
	@Override
	public List getCatagoriesByType(int type)  throws ServiceException{
		// TODO Auto-generated method stub
		int leftCodeLength=0;
		String vl=null;
		if(type==1){
			leftCodeLength=Integer.parseInt(sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.SM_CTGRY_LNGTH))+
					Integer.parseInt(sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.PRDT_LNGTH));
		}
		else if(type==2){
			vl=getPropertyVl("MATERIAL_LNGTH");
			leftCodeLength=Integer.parseInt(sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.MATERIAL_LNGTH));
		}
		else if(type==3){
			vl=getPropertyVl("WARPPERS_LNGTH");
			leftCodeLength=Integer.parseInt(sysPropotyDao.getSysPropotyByKey(SYS_PROPERTY.WARPPERS_LNGTH));
		}
		List<Catagories> list = baseDAO.findByHQL("from Catagories where type=? and status!=1",
				new Object[]{type});
		List results=new ArrayList();
		for(Catagories catagory :list){
			CatagoryVo vo=new CatagoryVo();
			vo.setCodelength(vl);
			try {
				BeanUtils.copyProperties(vo, catagory);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			results.add(vo);
		}
		CatagoryVo vo=new CatagoryVo();
		vo.setLength(leftCodeLength);
		results.add(vo);
		return results;
	}
	
	@Override
	public List<Catagories> getUnSavedCatagoriesByType(int type)  throws ServiceException{
		// TODO Auto-generated method stub
		List<Catagories> list = baseDAO.findByHQL("from Catagories where type=? and status!=2",
				new Object[]{type});
		return list;
	}

	@Override
	public int addCatagory(int type, String name, int length,String rmk)
			throws ServiceException {
		// TODO Auto-generated method stub
		if(StringUtil.isBlank(name)){
			return 3;
		}
		List<Catagories> list=baseDAO.findByHQL("from Catagories where type=? and tempName=? and status!=2",
				new Object[]{type,name});
		if(list.size()>0){
			return 1;
		}
		int count=baseDAO.getTotalSize("from Catagories where type=? and status!=2", new Object[]{type});
		if(count>=6){
			return 2;
		}
		if(type==1){
			count=baseDAO.getTotalSize("from SameCatagories");
			if(count>0){
				return 4;
			}
		}else if(type==2){
			count=baseDAO.getTotalSize("from Materials");
			if(count>0){
				return 5;
			}
		}else if(type==3){
			count=baseDAO.getTotalSize("from Wrappers");
			if(count>0){
				return 6;
			}
		}
		Catagories catagory=new Catagories();
		catagory.setType(type);
		catagory.setTempName(name);
		catagory.setTempLength(length);
		catagory.setTempRmk(rmk);
		catagory.setStatus(1);
		baseDAO.save(catagory);
		return 0;
	}

	@Override
	public int deleteCatagory(Long catagoryId) throws ServiceException {
		// TODO Auto-generated method stub
		int count=baseDAO.getTotalSize("from CatagoryDetails where catagories.id=?",
				new Object[]{catagoryId});
		if(count>0){
			return 1;
		}
		Catagories catagory=baseDAO.findById(catagoryId, Catagories.class);
		if(catagory.getStatus()==0){
			catagory.setStatus(2);
			baseDAO.save(catagory);
		}else{
			baseDAO.delete(catagory);
		}
		return 0;
	}

	@Override
	public int editCatagory(Long catagoryId, String name, int length,String rmk)
			throws ServiceException {
		// TODO Auto-generated method stub
		if(StringUtil.isBlank(name)){
			return 3;
		}
		Catagories catagory=baseDAO.findById(catagoryId, Catagories.class);
		List list=baseDAO.findByHQL("from Catagories where type=? and tempName=? and tempName!=?",
				new Object[]{catagory.getType(),name,catagory.getName()});
		if(list.size()>0){
			return 1;
		}
		list=getCatagoryDetails(catagoryId+"");
		if(list.size()>0&&length!=catagory.getLength()){
			return 2;
		}
		catagory.setTempName(name);
		catagory.setTempLength(length);
		catagory.setTempRmk(rmk);
		baseDAO.update(catagory);
		return 0;
	}

	@Override
	public List<CatagoryDetails> getCatagoryDetails(String catagoryId)  throws ServiceException{
		// TODO Auto-generated method stub
		List<CatagoryDetails> list=baseDAO.findByHQL("from CatagoryDetails where catagories.id=? order by code",new Object[]{Long.parseLong(catagoryId)});
		return list;
	}

	@Override
	public int addCatagoryDetail(Long catagoryId,
			String catagoryCd, String name)  throws ServiceException{
		// TODO Auto-generated method stub
		if(StringUtil.isBlank(name)){
			return 3;
		}
		List<CatagoryDetails> list=baseDAO.findByHQL("from CatagoryDetails where catagories.id=? and name=?",
				new Object[]{catagoryId,name});
		if(list.size()>0){
			return 1;
		}
		Catagories catagory=baseDAO.findById(catagoryId, Catagories.class);
		CatagoryDetails catagoryDetail=new CatagoryDetails();
		catagoryDetail.setCatagories(catagory);
		catagoryDetail.setCode(catagoryCd);
		catagoryDetail.setName(name);
		catagoryDetail.setUpdTm(DateUtil.getCurrentTime());
		baseDAO.save(catagoryDetail);
		return 0;
	}

	@Override
	public int deleteCatagoryDetail(Long catagoryDetailId)  throws ServiceException{
		// TODO Auto-generated method stub
		CatagoryDetails catagoryDetail=baseDAO.findById(catagoryDetailId, CatagoryDetails.class);
		if(catagoryDetail.getCatagories().getType()==1){
			int count=catagoryDetail.getSameCatagorysDetailses().size();
			if(count>0){
				return 1;
			}
		}else if(catagoryDetail.getCatagories().getType()==2){
			int count=catagoryDetail.getMaterialCatagoryDetailses().size();
			if(count>0){
				return 2;
			}
		}else if(catagoryDetail.getCatagories().getType()==3){
			int count=catagoryDetail.getWrapperCatagoryDetailses().size();
			if(count>0){
				return 3;
			}
		}
		baseDAO.delete(catagoryDetail);
		return 0;
	}

	@Override
	public int editCatagoryDetail(Long catagoryDetailId, String catagoryCd,
			String name)  throws ServiceException{
		// TODO Auto-generated method stub
		if(StringUtil.isBlank(name)){
			return 3;
		}
		CatagoryDetails catagoryDetails=baseDAO.findById(catagoryDetailId, CatagoryDetails.class);
		List<CatagoryDetails> list=baseDAO.findByHQL("from CatagoryDetails where catagories.id=? and name=?",
				new Object[]{catagoryDetails.getCatagories().getId(),name});
		if(list.size()>0){
			return 1;
		}
		catagoryDetails.setCode(catagoryCd);
		catagoryDetails.setName(name);
		catagoryDetails.setUpdTm(DateUtil.getCurrentTime());
		baseDAO.update(catagoryDetails);
		return 0;
	}

	@Override
	public Map getCodesLength(String type) throws ServiceException {
		// TODO Auto-generated method stub
		int totalLength=0;
		int catagoryLength=0;
		int sameCatagoryLength=0;
		int sameCatagoryNum=0;
		int bitLength=0;
		int num=0;
		List<Catagories> list = baseDAO.findByHQL("from Catagories where type=? and status!=2",
				new Object[]{Integer.parseInt(type)});
		for(Catagories catagories:list){
			catagoryLength+=catagories.getTempLength();
		}
		List<SysProperty> propertyList;
		String propotyKey="";
		if(type.equals("1")){
			propotyKey=SYS_PROPERTY.PRDT_LNGTH;
			propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.SM_CTGRY_LNGTH, SysProperty.class);
			if(propertyList.size()!=0){
				SysProperty property=propertyList.get(0);
				sameCatagoryLength=Integer.parseInt(property.getPropotyVl());
			}
			num=baseDAO.getTotalSize("from Products");
			sameCatagoryNum=baseDAO.getTotalSize("from SameCatagories");
		}else if(type.equals("2")){
			propotyKey=SYS_PROPERTY.MATERIAL_LNGTH;
			num=baseDAO.getTotalSize("from Materials");
		}else if(type.equals("3")){
			propotyKey=SYS_PROPERTY.WARPPERS_LNGTH;
			num=baseDAO.getTotalSize("from Wrappers");
		}
		propertyList=baseDAO.findByProperty("propotyKey", propotyKey, SysProperty.class);
		if(propertyList.size()!=0){
			SysProperty property=propertyList.get(0);
			bitLength=Integer.parseInt(property.getPropotyVl());
		}
		totalLength=catagoryLength+sameCatagoryLength+bitLength;
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("totalLength", totalLength);
		map.put("catagoryLength", catagoryLength);
		map.put("sameCatagoryLength", sameCatagoryLength);
		map.put("bitLength", bitLength);
		map.put("num", num);
		map.put("sameCatagoryNum", sameCatagoryNum);
		return map;
	}

	@Override
	public String getPropertyVl(String propotyKey) throws ServiceException {
		// TODO Auto-generated method stub
		List<SysProperty> list=baseDAO.findByHQL("from SysProperty where propotyKey =?", new Object[]{propotyKey});
		String value=list.get(0).getPropotyVl();
		return value;
	}

	@Override
	public Catagories getTypebyId(String catagoryId) throws ServiceException {
		// TODO Auto-generated method stub
		Catagories catagories=baseDAO.findById(Long.parseLong(catagoryId), Catagories.class);
		return catagories;
	}

	@Override
	public int saveCodesLength(String type, String bitLength,
			String sameCatagoryLength) throws ServiceException {
		// TODO Auto-generated method stub
		if(!StringUtil.isInteger(bitLength)||Integer.parseInt(bitLength)<1
				||(type.equals("1")&&(!StringUtil.isInteger(sameCatagoryLength)||Integer.parseInt(sameCatagoryLength)<1))){
			return 1;
		}
		String propotyKey="";
		List<SysProperty> propertyList;
		if(type.equals("1")){
			propotyKey=SYS_PROPERTY.PRDT_LNGTH;
			propertyList=baseDAO.findByProperty("propotyKey", SYS_PROPERTY.SM_CTGRY_LNGTH, SysProperty.class);
			if(propertyList.size()!=0){
				SysProperty property=propertyList.get(0);
				property.setPropotyVl(sameCatagoryLength);
				baseDAO.update(property);
			}
		}else if(type.equals("2")){
			propotyKey=SYS_PROPERTY.MATERIAL_LNGTH;
		}else if(type.equals("3")){
			propotyKey=SYS_PROPERTY.WARPPERS_LNGTH;
		}
		propertyList=baseDAO.findByProperty("propotyKey", propotyKey, SysProperty.class);
		if(propertyList.size()!=0){
			SysProperty property=propertyList.get(0);
			property.setPropotyVl(bitLength);
			baseDAO.update(property);
		}
		baseDAO.executeSQL("update CATAGORIES set name=temp_Name,rmk=temp_Rmk,length=temp_Length");
		baseDAO.executeSQL("delete from CATAGORIES where status=2");
		baseDAO.executeSQL("update CATAGORIES set status=0");
		return 0;
	}

	@Override
	public int resetCatagory() throws ServiceException {
		// TODO Auto-generated method stub
		List<Catagories> list=baseDAO.findByProperty("status", 1, Catagories.class);
		for(Catagories catagory:list){
			baseDAO.delete(catagory);
		}
		baseDAO.executeSQL("update catagories set status=0 where status=2");
		baseDAO.executeSQL("update catagories set temp_Name=name,temp_Rmk=rmk,temp_Length=length");
		return 0;
	}

	@Override
	public List<CatagoryVo> getCatagoriesAndDetailsByType(int type)
			throws ServiceException {
		// TODO Auto-generated method stub
		List<CatagoryVo> results=new ArrayList<CatagoryVo>();
		List<Catagories> list = baseDAO.findByHQL("from Catagories where type=? and status!=1",
				new Object[]{type});
		for(Catagories catagory :list){
			CatagoryVo vo=new CatagoryVo();
			try {
				BeanUtils.copyProperties(vo, catagory);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List children=baseDAO.findByHQL("from CatagoryDetails where catagories=?",
					new Object[]{catagory});
			List catagoryDetailVoList=new ArrayList();
			for(Object obj : children){
				CatagoryDetails details=(CatagoryDetails)obj;
				CatagoryDetailVo detailVo=new CatagoryDetailVo();
				detailVo.setId(details.getId());
				detailVo.setCode(details.getCode());
				detailVo.setName("("+details.getCode()+")"+details.getName());
				
				catagoryDetailVoList.add(detailVo);
			}
			vo.setCatagoryDetails(catagoryDetailVoList);
			results.add(vo);
		}
		return results;
	}
}
