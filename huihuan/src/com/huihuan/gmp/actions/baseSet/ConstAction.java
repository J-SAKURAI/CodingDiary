package com.huihuan.gmp.actions.baseSet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.Catagories;
import com.huihuan.gmp.entity.CatagoryDetails;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.baseSet.ICatagoryService;
import com.huihuan.gmp.services.baseSet.IConstService;
import com.huihuan.gmp.services.baseSet.IConstService;
import com.huihuan.gmp.services.baseSet.ISameCatagoryService;
import com.huihuan.gmp.vo.CatagoryDetailVo;
import com.huihuan.gmp.vo.CatagoryVo;
import com.huihuan.gmp.vo.ConstVo;
import com.huihuan.gmp.vo.SameCatagoryVo;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ConstAction extends BaseAction {

	@Resource
	private IConstService constService;

	private BaseJson queryJson = new BaseJson();

	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}

	public String getConsts() {
		queryJson = new BaseJson();
		try {
			String mlCd = getHttpRequest().getParameter("mlCd");
			String type = getHttpRequest().getParameter("type");
			List list = constService.getConsts(mlCd, type);
			queryJson.setObj(list);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}

	public String searchConsts() {
		queryJson = new BaseJson();
		try {
			int queryPage = Integer.parseInt( getHttpRequest().getParameter("queryPage"));
			int pageSize = Integer.parseInt( getHttpRequest().getParameter("pageSize"));
			String orderPropoty = getHttpRequest().getParameter("orderPropoty");
			String orderType = getHttpRequest().getParameter("orderType");
			String keyword = getHttpRequest().getParameter("keyword");
			Map map = constService.searchConsts(queryPage,pageSize,keyword,orderPropoty,orderType);
			queryJson.setObj(map);
		} catch (ServiceException e) {
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}

	public String addConst() {
		queryJson = new BaseJson();
		try {
			String mlCd;
			String type;
			String value;
			String ky;
			Integer ordr;
			String rmk;

			if (getHttpRequest().getParameter("mlCd") == "") {
				mlCd = null;
			} else {
				mlCd = getHttpRequest().getParameter("mlCd");
			}

			if (getHttpRequest().getParameter("type") == "") {
				type = null;
			} else {
				type = getHttpRequest().getParameter("type");
			}

			if (getHttpRequest().getParameter("value") == "") {
				value = null;
			} else {
				value = getHttpRequest().getParameter("value");
			}
			if (getHttpRequest().getParameter("ky") == "") {
				ky = null;
			} else {
				ky = getHttpRequest().getParameter("ky");
			}
			if (getHttpRequest().getParameter("ordr") == "") {
				ordr = null;
			} else {
				ordr = Integer.parseInt(getHttpRequest().getParameter("ordr"));
			}
			if (getHttpRequest().getParameter("rmk") == "") {
				rmk = null;
			} else {
				rmk = getHttpRequest().getParameter("rmk");
			}

			ConstVo vo = new ConstVo();
			vo.setMlCd(mlCd);
			vo.setType(type);
			vo.setValue(value);
			vo.setKy(ky);
			vo.setOrdr(ordr);
			vo.setRmk(rmk);

			int result = constService.addConst(vo);
			if (result == 0) {
				queryJson.setRetcode("0000");
			} else {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("增加失败！");
			}

		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonResult";
	}

	public String deleteConst() {
		queryJson = new BaseJson();
		try {
			String id = getHttpRequest().getParameter("itemId");
			int result = constService.deleteConst(id);
			if (result == 0) {
				queryJson.setRetcode("0000");
			} else {
				queryJson.setRetcode("0001");
				queryJson.setErrorMsg("删除失败！");
			}
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String getConst() {
		queryJson = new BaseJson();
		try {
			String id = getHttpRequest().getParameter("itemId");
			ConstVo vo = constService.getConst(id);
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String editConst() {
		queryJson = new BaseJson();
		try {
			String id = getHttpRequest().getParameter("itemId");
			String mlCd;
			String type;
			String value;
			String ky;
			Integer ordr;
			String rmk;
			
			if (getHttpRequest().getParameter("mlCd") == "") {
				mlCd = null;
			} else {
				mlCd = getHttpRequest().getParameter("mlCd");
			}

			if (getHttpRequest().getParameter("type") == "") {
				type = null;
			} else {
				type = getHttpRequest().getParameter("type");
			}

			if (getHttpRequest().getParameter("value") == "") {
				value = null;
			} else {
				value = getHttpRequest().getParameter("value");
			}
			if (getHttpRequest().getParameter("ky") == "") {
				ky = null;
			} else {
				ky = getHttpRequest().getParameter("ky");
			}
			if (getHttpRequest().getParameter("ordr") == "") {
				ordr = null;
			} else {
				ordr = Integer.parseInt(getHttpRequest().getParameter("ordr"));
			}
			if (getHttpRequest().getParameter("rmk") == "") {
				rmk = null;
			} else {
				rmk = getHttpRequest().getParameter("rmk");
			}
			
			ConstVo vo = new ConstVo();
			vo.setMlCd(mlCd);
			vo.setType(type);
			vo.setValue(value);
			vo.setKy(ky);
			vo.setOrdr(ordr);
			vo.setRmk(rmk);
			int result = constService.editConst(id, vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

	public String getUnits() {
		queryJson = new BaseJson();
		try {
			String type = getHttpRequest().getParameter("type");
			List list = constService.getUnits(type);
			queryJson.setObj(list);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}

}
