package com.dais.service;

import java.util.List;
import java.util.Map;

import com.dais.ext.AcceptedParam;
import com.dais.ext.Pageable;

public interface BaseService<T>{
	/**
	 * 保存
	 * @param t
	 */
	public void save(T t);
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer... ids);
	/**
	 * 修改
	 * @param t
	 */
	public void update(T t);
	/**
	 * 查找
	 * @param id
	 */
	public T find(Integer id);
	/**
	 * 查找
	 * @param hql//hql
	 * @param map//
	 * @return
	 */
	public List<T> findByHql(String hql,Map<String,Object> map);
	/**
	 * 查找
	 * @param hql
	 * @param params //
	 * @return
	 */
	public List<T> findByHql(String hql, Object[] params);
	/**
	 * 分页
	 * @param hql
	 * @param params
	 * @return
	 */
	public Pageable paging(String hql,AcceptedParam acceptedParam,Object[] params);
}
