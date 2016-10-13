package com.huihuan.gmp.daos.baseSet;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.huihuan.common.util.StringUtil;
import com.huihuan.gmp.cst.SYS_PROPERTY;
import com.huihuan.gmp.daos.BaseDAO;
import com.huihuan.gmp.entity.SysProperty;

@Repository("sysPropotyDao")
public class SysPropotyDao extends BaseDAO{
	public String getSysPropotyByKey(String key){
		String reuslt=null;
		List<SysProperty> list=findByProperty("propotyKey", key, SysProperty.class);
		if(list.size()>0){
			reuslt=list.get(0).getPropotyVl();
		}
		return reuslt;
	}

	public void saveSysPropotyByKey(String key,String value){
		List<SysProperty> list=findByProperty("propotyKey", key, SysProperty.class);
		if(list.size()>0){
			list.get(0).setPropotyVl(value);
			save(list.get(0));
		}
	}
	
	public synchronized String getAndIncSysPropotyByKey(String key){
		String reuslt=null;
		int temp=0;
		List<SysProperty> list=findByProperty("propotyKey", key, SysProperty.class);
		if(list.size()>0){
			reuslt=list.get(0).getPropotyVl();
			if(StringUtil.isBlank(reuslt)){
				reuslt="0";
			}
			temp=Integer.parseInt(reuslt);
			list.get(0).setPropotyVl(String.valueOf(temp+1));
			save(list.get(0));
		}		
		return StringUtil.frontCompWithZore(temp,8);
	}
}
