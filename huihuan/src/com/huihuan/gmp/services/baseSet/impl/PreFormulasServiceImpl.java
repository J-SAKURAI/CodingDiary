package com.huihuan.gmp.services.baseSet.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.huihuan.common.util.DateUtil;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.cst.STATUS;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.Formulas;
import com.huihuan.gmp.entity.Materials;
import com.huihuan.gmp.entity.PreFormulaMaterials;
import com.huihuan.gmp.entity.PreFormulas;
import com.huihuan.gmp.services.baseSet.IPreFormulasService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.ConstVo;
import com.huihuan.gmp.vo.PreFormulaMaterialsVo;
import com.vladium.emma.ctl.ctlTask.commandElement;

@Service(value = "preformulasService")
public class PreFormulasServiceImpl extends CommServiceImpl implements
         IPreFormulasService{
	
    
	private Log log = LogFactory.getLog(PreFormulasServiceImpl.class);

	@Override
	public List<PreFormulas> getPreFormulas(String materialId)
			throws ServiceException {
		// TODO Auto-generated method stub
		if(!StringUtil.isEmpty(materialId)){
			Long mId=Long.parseLong(materialId);
			List<PreFormulas> list = baseDAO.findByHQL("from PreFormulas where materials.id = ?", new Object[]{mId});
			return list;
		}
		return null;
		
	}
	
	public Map getMaterials(String queryPage,
			String size,String keyword,String orderPropoty,String orderType,String materialsCata,String status) throws ServiceException {
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
		
		String sql="select code as code,name as name,status as status,catagory_code as catagoryCode " +
				"from materials ";
		
		List params=new ArrayList();
		if (keyword!=null&&!keyword.equals("")){
			sql+="where materials.name like ?";
			params.add("%" + keyword + "%");
			if(!materialsCata.equals("-1")){
		        sql+="and materials.catagory_code = ? ";
		        params.add(materialsCata);}
	        if(status.equals("1")){
				sql+="and materials.status = ? ";
		        params.add(2);
			 }    
		}else{
				if(!materialsCata.equals("-1")){
		        sql+="where materials.catagory_code = ? ";
		        params.add(materialsCata);
		        if(status.equals("1")){
					sql+="and materials.status = ? ";
			        params.add(2);
				 }
			    }else{
			    	if(status.equals("1")){
						sql+="where materials.status = ? ";
				        params.add(2);
					 }
			    }
			}
		
		if(!StringUtil.isBlank(orderPropoty)){
			sql+="order by "+orderPropoty+" "+orderType;
		}
		List resultList=baseDAO.findBySQLForVO(sql,Materials.class, params.toArray(), offset, pageSize);
		Iterator<Materials>iterator=resultList.iterator();
		while(iterator.hasNext()){
			Materials tmp=iterator.next();
			tmp.setCode(tmp.getCatagoryCode()+tmp.getCode());
		}
		map.put("list", resultList);
		return map;
	}
	
	@Override
	public List<PreFormulaMaterials> getPreFormulasMaterials(String preformulaId)
			throws ServiceException {
		// TODO Auto-generated method stub
		
		
		if(!StringUtil.isEmpty(preformulaId)){
			List<PreFormulaMaterials> list = baseDAO.findByHQL("from PreFormulaMaterials where preFormulas.id= ?", new Object[]{Long.parseLong(preformulaId)});
			return list;
		}
		else
		   return null;
	}

	@Override
	public int updatePreFormulasItem(PreFormulaMaterialsVo vo)
			throws ServiceException {
		// TODO Auto-generated method stub
		if(!StringUtil.isEmpty(vo.getId())){
			PreFormulaMaterials formulaMaterials=baseDAO.findById(Long.parseLong(vo.getId()),PreFormulaMaterials.class);
			if((vo.getMocProductQuantity()!=null)&&(!vo.getMocProductQuantity().isEmpty())){
				Float mocProductQuantity=Float.parseFloat(vo.getMocProductQuantity());
				formulaMaterials.setMocProductQuantity(mocProductQuantity);
			}
			
			if((vo.getConfigQuantity()!=null)&&(!vo.getConfigQuantity().isEmpty())){
				Float configQuantity=Float.parseFloat(vo.getConfigQuantity());
				formulaMaterials.setConfigQuantity(configQuantity);	
			}
			
			if((vo.getFormulaGroup()!=null)&&(!vo.getFormulaGroup().isEmpty()))
				formulaMaterials.setFormulaGroup(vo.getFormulaGroup());
			
			if((vo.getIncreasedQuantity()!=null)&&(!vo.getIncreasedQuantity().isEmpty())){
				Float increasedQuantity=Float.parseFloat(vo.getIncreasedQuantity());
				formulaMaterials.setIncreasedQuantity(increasedQuantity);
			}
			
			if((vo.getDifferences()!=null)&&(!vo.getDifferences().isEmpty())){
				Float differences=Float.parseFloat(vo.getDifferences());
				formulaMaterials.setDifferences(differences);
			}
			if((vo.getIsUseDifferences()!=null)&&(!vo.getIsUseDifferences().isEmpty())){
				Integer IsUseDifferences=Integer.parseInt(vo.getIsUseDifferences());
				formulaMaterials.setIsUseDifferences(IsUseDifferences);
			}
			if((vo.getIncreaseProportion()!=null)&&(!vo.getIncreaseProportion().isEmpty())){
				Float increaseProportion=Float.parseFloat(vo.getIncreaseProportion());
				formulaMaterials.setIncreaseProportion(increaseProportion);
			}
			if((vo.getIsMain()!=null)&&(!vo.getIsMain().isEmpty())){
				Integer isMain=Integer.parseInt(vo.getIsMain());
				formulaMaterials.setIsMain(isMain);
			}
			if((vo.getIsCalculateBalance()!=null)&&(vo.getIsCalculateBalance().isEmpty())){
				Integer iscalculateBalance=Integer.parseInt(vo.getIsCalculateBalance());
				formulaMaterials.setIsCalculateBalance(iscalculateBalance);
			}
			if((vo.getSupplementFormula()!=null)&&(!vo.getSupplementFormula().isEmpty()))
				formulaMaterials.setSupplementFormula(vo.getSupplementFormula());
			
			baseDAO.update(formulaMaterials);
			return 0;	
		}
		else
			return 1;
		
		
	}

	@Override
	public int deletePreFormulasItem(String Id) throws ServiceException {
		// TODO Auto-generated method stub
		if(!StringUtil.isEmpty(Id)){
			PreFormulaMaterials preFormulaMaterials=baseDAO.findById(Long.parseLong(Id),PreFormulaMaterials.class);
			baseDAO.delete(preFormulaMaterials);
			return 0;
		}
		else
			return 1;
		
	}

	@Override
	public Materials getMaterialByName(String materialname)
			throws ServiceException {
		// TODO Auto-generated method stub
			List<Materials> list=baseDAO.findByHQL("from Materials where name=?", new Object[]{materialname});
			Materials materials=list.get(0);
			return materials;
		
	}
	

	List<PreFormulaMaterials> PreFormulaMateriallist=new ArrayList<PreFormulaMaterials>();

	@Override
	public int addpreformulasItem(PreFormulaMaterialsVo vo,HttpSession session)
			throws ServiceException {
		// TODO Auto-generated method stub
		PreFormulaMaterials preFormulaMaterials=new PreFormulaMaterials();
		Materials materials=getMaterialById(vo.getMaterialId());
		PreFormulas preFormulas=getPreFormulasById(vo.getPreFormulId());
		
		if(vo.getPreFormulId()!=null&&!vo.getPreFormulId().isEmpty()){
			preFormulaMaterials.setPreFormulas(preFormulas);
		}
		preFormulaMaterials.setMaterials(materials);
		if((vo.getFormulaGroup()!=null)&&(!vo.getFormulaGroup().isEmpty())){
			preFormulaMaterials.setFormulaGroup(vo.getFormulaGroup());
		}
		if((vo.getMocProductQuantity()!=null)&&(!vo.getMocProductQuantity().isEmpty())){
			Float MocProductQuantity=Float.parseFloat(vo.getMocProductQuantity());
			preFormulaMaterials.setMocProductQuantity(MocProductQuantity);
		}
		if((vo.getConfigQuantity()!=null)&&(!vo.getConfigQuantity().isEmpty())){
			Float ConfigQuantity=Float.parseFloat(vo.getConfigQuantity());
			preFormulaMaterials.setConfigQuantity(ConfigQuantity);
		}
		if((vo.getIncreasedQuantity()!=null)&&(!vo.getIncreasedQuantity().isEmpty())){
			Float IncreasedQuantity=Float.parseFloat(vo.getIncreasedQuantity());
			preFormulaMaterials.setIncreasedQuantity(IncreasedQuantity);
		}
		if((vo.getDifferences()!=null)&&(!vo.getDifferences().isEmpty())){
			Float differences=Float.parseFloat(vo.getDifferences());
			preFormulaMaterials.setDifferences(differences);
		}
		if((vo.getIsUseDifferences()!=null)&&(!vo.getIsUseDifferences().isEmpty())){
			Integer IsUseDifferences=Integer.parseInt(vo.getIsUseDifferences());
			preFormulaMaterials.setIsUseDifferences(IsUseDifferences);
		}
		if((vo.getIncreaseProportion()!=null)&&(!vo.getIncreaseProportion().isEmpty())){
			Float increaseProportion=Float.parseFloat(vo.getIncreaseProportion());
			preFormulaMaterials.setIncreaseProportion(increaseProportion);
		}
		if((vo.getIsMain()!=null)&&(!vo.getIsMain().isEmpty())){
			Integer isMain=Integer.parseInt(vo.getIsMain());
			preFormulaMaterials.setIsMain(isMain);
		}
		if((vo.getIsCalculateBalance()!=null)&&(vo.getIsCalculateBalance().isEmpty())){
			Integer iscalculateBalance=Integer.parseInt(vo.getIsCalculateBalance());
			preFormulaMaterials.setIsCalculateBalance(iscalculateBalance);
		}
		if((vo.getSupplementFormula()!=null)&&(!vo.getSupplementFormula().isEmpty()))
			preFormulaMaterials.setSupplementFormula(vo.getSupplementFormula());
		
		PreFormulaMateriallist.add(preFormulaMaterials);
	
		session.setAttribute("preFormulaMaterialItem", PreFormulaMateriallist);
		
		
		return 0;
	}

	@Override
	public int addPreFormulas(List<PreFormulaMaterials> list,String MaterialId,String FormulasCode)
			throws ServiceException {
		// TODO Auto-generated method stub
		if(list.size()==0)    //增加项为空
			return 1;
		Materials materials=baseDAO.findById(MaterialId,Materials.class);
		PreFormulas formulas=new PreFormulas();
		formulas.setMaterials(materials);
		formulas.setCode(FormulasCode);
		formulas.setStatus(STATUS.ENABLE);//状态
		formulas.setCheckStatus(1);//审核状态
		formulas.setUpdTm(DateUtil.getCurrentTime());
		baseDAO.save(formulas);
		for(PreFormulaMaterials pf:list){
			pf.setPreFormulas(formulas);
			pf.setUpdTm(DateUtil.getCurrentTime());
			baseDAO.save(pf);	
		}
		return 0;
	}

	@Override
	public Materials getMaterialById(String id) throws ServiceException {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(id)){
			Long Id=Long.parseLong(id);
			Materials materials=baseDAO.findById(id, Materials.class);
			return materials;
		}
		else
		      return null;
	}

	@Override
	public PreFormulas getPreFormulasById(String id) throws ServiceException {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(id)){
			Long Id=Long.parseLong(id);
			PreFormulas preFormulas=baseDAO.findById(id, PreFormulas.class);
			return preFormulas;
		}
		else
			return null;
	}


	public List getMaterialsCata() throws ServiceException {
		// TODO Auto-generated method stub
	
	    List resultList=new ArrayList();
		
		String hql=" from CatagoryDetails where catagories = 36";
		
		List list =baseDAO.findByHQL(hql);
		for(Object object:list){
			CatagoryDetails catagoryDetails=(CatagoryDetails)object;
			 CatagoryDetailVo vo=new CatagoryDetailVo();
			 vo.setCode(catagoryDetails.getCode());
			 vo.setName(catagoryDetails.getName());
			 resultList.add(vo);
		}
		
		
		return resultList;
	}
}
