package com.dais.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.dais.dao.impl.ICommonDaoImpl;
import com.dais.ext.AcceptedParam;
import com.dais.ext.Pageable;
import com.dais.service.BaseService;

/**
 * 所有service的基类
 * @author dais
 *
 * @param <T>
 */
public class BaseServiceImpl<T> extends ICommonDaoImpl<T> implements BaseService<T>{

	@Override
	public T find(Integer id) {
		return super.find(id);
	}

	@Override
	public void save(T t) {
		super.save(t);
	}

	@Override
	public void delete(Integer... ids) {
		super.delete(ids);
	}

	@Override
	public void update(T t) {
		super.update(t);
	}
	
	@Override
	public List<T> findByHql(String hql, Map<String, Object> map) {
		return super.findByHql(hql, map);
	}

	@Override
	public List<T> findByHql(String hql, Object[] params) {
		return super.findByHql(hql, params);
	}

	public Pageable paging(String hql,AcceptedParam acceptedParam ,Object[] params) {
		int pageSize=acceptedParam.getRows();
		int pageNow=acceptedParam.getPage();
		pageSize=pageSize==0?20:pageSize;
		pageNow=pageNow==0?1:pageNow;
	
		Query query=super.getCurrentSession().createQuery(hql);
		if(params!=null){
			for(int i=0;i<params.length;i++){
				query.setParameter(i, params[i]);
			}
		}
		List<T> allDatas=query.list();
		int lastIndex=pageSize*(pageNow-1)+pageSize;
		
		List<T> datas;
		if(lastIndex<allDatas.size()){
			if(lastIndex==0){
				lastIndex=allDatas.size();
			}
			datas=allDatas.subList(pageSize*(pageNow-1),lastIndex);
		}else{
			datas=allDatas.subList(pageSize*(pageNow-1),allDatas.size());
		}
		Pageable pageable=new Pageable();
		pageable.setRows(datas);
		pageable.setTotal(datas.size());
		return pageable;
	}

	

}
