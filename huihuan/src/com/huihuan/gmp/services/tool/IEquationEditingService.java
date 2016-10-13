package com.huihuan.gmp.services.tool;

import javax.script.ScriptException;

import com.huihuan.gmp.services.common.ICommService;

public interface IEquationEditingService extends ICommService{
	public String equationConfirm(String formulaDefinition,String parameter,String parameterName) throws ScriptException;

}
