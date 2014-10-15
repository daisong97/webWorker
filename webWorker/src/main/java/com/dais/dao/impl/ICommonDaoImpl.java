package com.dais.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dais.common.utils.ReflectUtils;
import com.dais.dao.ICommonDao;



public class ICommonDaoImpl<T> implements ICommonDao<T>{
	@Autowired SessionFactory factory;
	
	Class<?> entityClass;
	public ICommonDaoImpl() {
		entityClass=ReflectUtils.getGenericSuperFormClass(this.getClass());
	}
	public Session getCurrentSession(){
		return factory.getCurrentSession();
	}
	
	public void save(T t) {
		getCurrentSession().save(t);
	}

	public void delete(Integer... ids) {
		for(int i=0;ids!=null&&i<ids.length;i++){
			getCurrentSession().delete(find(ids[i]));
		}
	}

	public void update(T t) {
		getCurrentSession().update(t);
	}

	public T find(Integer id) {
		return (T)getCurrentSession().get(entityClass, id);
	}
	
	
	public List<T> findByHql(String hql,Object... params) {
		Query query=getCurrentSession().createQuery(hql);
		for(int i=0;params!=null&&i<params.length;i++){
			query.setParameter(i, params[i]);
		}
		return query.list();
	}
	
	public List<T> find(String sql){
		SQLQuery sqlQuery=getCurrentSession().createSQLQuery(sql);
		sqlQuery.addEntity(entityClass);
		List<T> list=sqlQuery.list();
		return list;
	}
	
	
	public List<T> findByHql(String hql, Map<String, Object> map) {
		Query query=getCurrentSession().createQuery(hql);
		query.setProperties(map);
		return query.list();
	}
	

}
