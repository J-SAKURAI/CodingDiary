package com.huihuan.gmp.actions.tool;

import javax.annotation.Resource;
import javax.script.ScriptException;

import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.baseSet.IProductFormulaService;
import com.huihuan.gmp.services.tool.IEquationEditingService;
import com.huihuan.gmp.services.tool.impl.EquationEditingServiceImpl;

public class EquationEditingAction extends BaseAction {
	private BaseJson queryJson = new BaseJson();
	
	@Resource
	IEquationEditingService equationEditingService;
	
	public BaseJson getQueryJson() {
		return queryJson;
	}
	
	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String equationConfirm() {
		// TODO Auto-generated method stub
		queryJson = new BaseJson();
		String formulaDefinition = getHttpRequest().getParameter("formulaDefinition");
		String parameterValue = getHttpRequest().getParameter("parameterValue"); 
		String parameterName = getHttpRequest().getParameter("parameterName"); 
		Double result = null;
		try {
			result = Double.parseDouble(equationEditingService.equationConfirm(formulaDefinition,parameterValue,parameterName));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			queryJson.setRetcode("0001");
			queryJson.setErrorMsg(e.getMessage());
			return "jsonResult";
		}
		queryJson.setRetcode("0000");
		queryJson.setObj(result);
		return "jsonResult";
	}
}
