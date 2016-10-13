package com.huihuan.gmp.actions.baseSet;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.entity.Materials;
import com.huihuan.gmp.entity.PreFormulaMaterials;
import com.huihuan.gmp.entity.PreFormulas;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.baseSet.IPreFormulasService;
import com.huihuan.gmp.vo.MaterialVo;
import com.huihuan.gmp.vo.PreFormulaMaterialVo;
import com.huihuan.gmp.vo.PreFormulaMaterialsVo;
import com.huihuan.gmp.vo.PreFormulasVo;

public class PreFormulasAction extends BaseAction {
	
    @Resource
	private IPreFormulasService preformulasService;
    
    private BaseJson queryJson=new BaseJson();
    
    public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	
	public String getMaterialsCata(){
		queryJson =new BaseJson();
		try {			
			
			 List resultlist = preformulasService.getMaterialsCata();
			queryJson.setRetcode("0000");
			queryJson.setObj(resultlist);
		} catch (ServiceException e) {
			processException(e, queryJson);
			queryJson.setRetcode("-1");
			queryJson.setErrorMsg(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			queryJson.setRetcode("-1");
			queryJson.setErrorMsg(e.getMessage());
		}
		return "jsonResult";
	}
	
	
	public String getPreFormulasList(){
		queryJson = new BaseJson();
		try{
			String materialId=getHttpRequest().getParameter("materialId");//获得原辅料编号
			List<PreFormulas> list=preformulasService.getPreFormulas(materialId);
			
			List result=new ArrayList();
			for(PreFormulas preformulas:list){
				PreFormulasVo vo=new PreFormulasVo();
				/*vo.setId(preformulas.getId());*/
				vo.setCode(preformulas.getCode());
				vo.setStatus(preformulas.getStatus());
				vo.setCheckStatus(preformulas.getCheckStatus());
				result.add(vo);
				
			}
			queryJson.setObj(result);
			
			
			
		}catch(ServiceException e){
			
			processException(e, queryJson);
			
		}catch (Exception e){
			processException(e, queryJson);
		}
		
		return "jsonResult";
	}
	
	
	public String getMaterials(){
		queryJson =new BaseJson();
		try {			
			String status = getHttpRequest().getParameter("status");
			System.out.println(status);
			String queryPage = getHttpRequest().getParameter("queryPage");
			String keyword=getHttpRequest().getParameter("keyword");
			String pageSize = getHttpRequest().getParameter("pageSize");
			String orderPropoty=getHttpRequest().getParameter("orderPropoty");
			String orderType=getHttpRequest().getParameter("orderType");
			String materialsCata=getHttpRequest().getParameter("MaterialsCata");
			Map map = preformulasService.getMaterials(queryPage,pageSize, keyword,orderPropoty,orderType,materialsCata,status);
			
			queryJson.setObj(map);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	
	public String getPreFormulasById(){
		queryJson=new BaseJson();
		try{
			
		}catch(Exception e){
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	
	
	
    public String getPreFormulasMaterials(){
    	queryJson = new BaseJson();
    	try{
    		String preformulaId=getHttpRequest().getParameter("preformulaId");
    		List<PreFormulaMaterials> list=preformulasService.getPreFormulasMaterials(preformulaId);
    		List result=new ArrayList();
    		for(PreFormulaMaterials preFormulaMaterials:list){
    			PreFormulaMaterialVo vo=new PreFormulaMaterialVo();
    			String code=preFormulaMaterials.getMaterials().getCatagoryCode()+preFormulaMaterials.getMaterials().getCode();
    			String unit=preFormulaMaterials.getMaterials().getUnitsByQuantityUnitId1().getName();
    			vo.setId(preFormulaMaterials.getId());
    			vo.setCode(code);
    			vo.setUnit(unit);
    			vo.setMaterialsName(preFormulaMaterials.getMaterials().getName());
    			vo.setFormulaGroup(preFormulaMaterials.getFormulaGroup());
    			vo.setMocProductQuantity(preFormulaMaterials.getMocProductQuantity());
    			vo.setConfigQuantity(preFormulaMaterials.getConfigQuantity());
    			vo.setIncreasedQuantity(preFormulaMaterials.getIncreasedQuantity());
    			vo.setDifferences(preFormulaMaterials.getDifferences());
    			vo.setIncreaseProportion(preFormulaMaterials.getIncreaseProportion());
    			vo.setIsMain(preFormulaMaterials.getIsMain());
    			vo.setIsUseDifferences(preFormulaMaterials.getIsUseDifferences());
    			vo.setIsCalculateBalance(preFormulaMaterials.getIsCalculateBalance());
    			result.add(vo);
    		}
    		queryJson.setObj(result);
    		
    	}catch(ServiceException e){
			
			processException(e, queryJson);
			
		}catch (Exception e){
			processException(e, queryJson);
		}
		
		return "jsonResult";
	}
    
    
    public String addPreFormulasitems(){
    	queryJson = new BaseJson();

    	try{
    		String preformulaId=getHttpRequest().getParameter("preformulaId");//预制品配方编号
//    		String materialcode=getHttpRequest().getParameter("materialcode");//原辅料编号
//    		String materialname=getHttpRequest().getParameter("materialname");//原辅料名称
    		String materialId=getHttpRequest().getParameter("materialId");
    		String unit=getHttpRequest().getParameter("unit");
			String formulaGroup=getHttpRequest().getParameter("formulaGroup");//分组
			String mocProductQuantity=getHttpRequest().getParameter("mocProductQuantity");//模拟生产量
			String configQuantity=getHttpRequest().getParameter("configQuantity");//配置量
			String increasedQuantity=getHttpRequest().getParameter("increasedQuantity");//掺入尾料增投
			String differences=getHttpRequest().getParameter("differences");//投量差异
			String isUseDifferences=getHttpRequest().getParameter("isUseDifferences");//是否启用投料差异
			String increaseProportion=getHttpRequest().getParameter("increaseProportion");//增投比例
			String isMain=getHttpRequest().getParameter("isMain");//是否主药
			String isCalculateBalance=getHttpRequest().getParameter("isCalculateBalance");//是否计入物料平衡
			String supplementFormula=getHttpRequest().getParameter("supplementFormula");//含量补差公式
			
			HttpSession session=getHttpRequest().getSession();//获取session


			PreFormulaMaterialsVo vo=new PreFormulaMaterialsVo();
			vo.setPreFormulId(preformulaId);
//			
            vo.setMaterialId(materialId);
			vo.setUnit(unit);
			vo.setFormulaGroup(formulaGroup);
			vo.setMocProductQuantity(mocProductQuantity);
			vo.setConfigQuantity(configQuantity);
			vo.setIncreasedQuantity(increasedQuantity);
			vo.setDifferences(differences);
			vo.setIsUseDifferences(isUseDifferences);
			vo.setIncreaseProportion(increaseProportion);
			vo.setIsMain(isMain);
            vo.setIsCalculateBalance(isCalculateBalance);
            vo.setSupplementFormula(supplementFormula);
            int result=preformulasService.addpreformulasItem(vo,session);	
    	}catch(ServiceException e){
    	    processException(e,queryJson);	
    	}catch (Exception e){
			processException(e, queryJson);
		}
    	
    	
		
		return "jsonResult";
    }
    
    
    //增加配方
    public String addPreFormulas(){
    	queryJson = new BaseJson();
    	try{
    		String MaterialId=getHttpRequest().getParameter("MaterialId");//预制品原辅料编号
    		String FormulasCode=getHttpRequest().getParameter("FormulasCode");//配方编号

			HttpSession session=getHttpRequest().getSession();//获取session
			List<PreFormulaMaterials> list=(List<PreFormulaMaterials>) session.getAttribute("PreFormulaMateriallist");
    		int result=preformulasService.addPreFormulas(list,MaterialId,FormulasCode);
    		if(result==1){
    			queryJson.setErrorMsg("增加项为空，配方增加无效！");
    			queryJson.setRetcode("0001");
    		}
    	}catch(ServiceException e){
    	    processException(e,queryJson);	
    	}catch (Exception e){
			processException(e, queryJson);
		}
    
		return "jsonResult";
    	
    }
    
    
    
    //单位未完成
    public String updatePreFormulasItem(){
    	queryJson = new BaseJson();
    	try{
			String Id = getHttpRequest().getParameter("Id");
			String mocProductQuantity=getHttpRequest().getParameter("mocProductQuantity");//模拟生产量
			String configQuantity=getHttpRequest().getParameter("configQuantity");//配置量
			String formulaGroup=getHttpRequest().getParameter("formulaGroup");//分组
			String increasedQuantity=getHttpRequest().getParameter("increasedQuantity");//掺入尾料增投
			String differences=getHttpRequest().getParameter("differences");//投量差异
			String isUseDifferences=getHttpRequest().getParameter("isUseDifferences");//是否启用投料差异

			String increaseProportion=getHttpRequest().getParameter("increaseProportion");//增投比例
			String isMain=getHttpRequest().getParameter("isMain");//是否主药
			String isCalculateBalance=getHttpRequest().getParameter("isCalculateBalance");//是否计入物料平衡
			String supplementFormula=getHttpRequest().getParameter("supplementFormula");//含量补差公式
			PreFormulaMaterialsVo vo=new PreFormulaMaterialsVo();
			vo.setId(Id);
			vo.setMocProductQuantity(mocProductQuantity);
			vo.setConfigQuantity(configQuantity);
			vo.setFormulaGroup(formulaGroup);
			vo.setIncreasedQuantity(increasedQuantity);
			vo.setDifferences(differences);
			vo.setIsUseDifferences(isUseDifferences);
            vo.setIncreaseProportion(increaseProportion);
            vo.setIsMain(isMain);
            vo.setIsCalculateBalance(isCalculateBalance);
            vo.setSupplementFormula(supplementFormula);
            
			int result=preformulasService.updatePreFormulasItem(vo);
			
			if(result==1){
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("未传入id!");
			}
	
    	}catch(ServiceException e){
    	    processException(e,queryJson);	
    	}catch (Exception e){
			processException(e, queryJson);
		}
    	
    	
		
		return "jsonResult";
    	
    	
    }
    
    
    
    public String deletePreFormulasItem(){
    	queryJson=new BaseJson();
    	try{
    		String Id=getHttpRequest().getParameter("itemId");
    		int result=preformulasService.deletePreFormulasItem(Id);
    		if(result==1){
        		queryJson.setErrorMsg("删除不成功！");
        		queryJson.setRetcode("0001");
        		
        	}
    	}catch(ServiceException e){
    		processException(e, queryJson);
    	}catch(Exception e){
    		processException(e, queryJson);
    	}
    	
		return "jsonResult";
    		
    	
    }
    
	

}
