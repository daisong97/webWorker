package com.dais.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * Dao基础类
 * @author dais
 *
 * @param <T>
 */
public interface ICommonDao<T> {
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
	 * 通过sql查询
	 * @param sql
	 * @return
	 */
	List<T> find(String sql);
}
