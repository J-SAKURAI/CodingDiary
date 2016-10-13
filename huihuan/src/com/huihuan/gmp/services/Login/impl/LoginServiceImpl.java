package com.huihuan.gmp.services.Login.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;

import com.huihuan.common.util.http.HttpClientConnectionManager;
import com.huihuan.framework.configurer.Configure;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Users;
import com.huihuan.gmp.services.Login.ILoginService;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;

import com.huihuan.common.util.http.HttpClientConnectionManager;
import redis.clients.jedis.Jedis;

@Service(value = "loginService")
public class LoginServiceImpl extends CommServiceImpl implements ILoginService{

	@Override
	public String getUsername(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoginName(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserInfo(String code) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int login(String name, String pwd) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
	