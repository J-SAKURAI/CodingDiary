package com.huihuan.gmp.services.baseSet;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.Materials;
import com.huihuan.gmp.entity.PreFormulaMaterials;
import com.huihuan.gmp.entity.PreFormulas;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.PreFormulaMaterialsVo;

public interface IPreFormulasService extends ICommService{
	public List<PreFormulas> getPreFormulas(String materialId)throws ServiceException;
	public List<PreFormulaMaterials> getPreFormulasMaterials(String preformulaId) throws ServiceException;
    public int updatePreFormulasItem(PreFormulaMaterialsVo vo)throws ServiceException;
    
    public int deletePreFormulasItem(String Id)throws ServiceException;
    public Materials getMaterialByName(String materialname)throws ServiceException;
    public int addpreformulasItem(PreFormulaMaterialsVo vo,HttpSession session)throws ServiceException;
    public int addPreFormulas(List<PreFormulaMaterials> list,String MaterialId,String FormulasCode)throws ServiceException;
    public Materials getMaterialById(String id)throws ServiceException;
    public PreFormulas getPreFormulasById(String id)throws ServiceException;
    public Map getMaterials(String queryPage,
			String size,String keyword,String orderPropoty,String orderType,String materialsCata,String status)  throws ServiceException;
    public List getMaterialsCata()  throws ServiceException;
}
