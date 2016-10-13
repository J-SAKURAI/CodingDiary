package com.huihuan.gmp.services.tool.impl;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.huihuan.gmp.services.baseSet.impl.PreFormulasServiceImpl;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.tool.IEquationEditingService;

@Service(value = "equationEditingService")
public class EquationEditingServiceImpl extends CommServiceImpl implements IEquationEditingService{
	private Log log = LogFactory.getLog(PreFormulasServiceImpl.class);
	@Override
	public String equationConfirm(String formulaDefinition, String parameterValue,String parameterName) throws ScriptException {
		// TODO Auto-generated method stub
		//处理公式：
		String command = formulaDefinition.replaceAll("ceil", "Math.ceil");
		command = command.replaceAll("abs", "Math.abs");
		command = command.replaceAll("round", "Math.round");
		command = command.replaceAll("floor", "Math.floor");
		command = command.replaceAll("sin", "Math.sin");
		command = command.replaceAll("cos", "Math.cos");
		command = command.replaceAll("PI", "Math.PI");
		command = command.replaceAll("sqrt", "Math.sqrt");
		
		//获取js脚本引擎：
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		
		//处理参数值：
		String []paramsValue=parameterValue.split(",");
		//处理参数名
		String []paramsName=parameterName.split(",");
		for(int i=0;i<paramsName.length;i++){
			engine.put(paramsName[i], Double.parseDouble(paramsValue[i]));
		}
		
		//执行脚本，返回结果：
		Object result = engine.eval(command);
		return result.toString();
	}
	
}
