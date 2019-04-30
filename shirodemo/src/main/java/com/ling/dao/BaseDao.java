package com.ling.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @ClassName: BaseDao
 * @Description: TODO
 * @author owen.he
 * @date Dec 21, 2017 9:38:00 AM
 *
 */
@Repository(value = "baseDao")
public class BaseDao extends BaseDaoSupport {

	/**
	 * 
	 */
	public BaseDao() {
		// TODO Auto-generated constructor stub
	}

	public int update(String nameSpace, Object whereParams) {
		return getSqlSession().update(nameSpace, whereParams);
	}

	public int update(String nameSpace) {
		return getSqlSession().update(nameSpace);
	}

	public int delete(String nameSpace, Object whereParams) {
		return getSqlSession().delete(nameSpace, whereParams);
	}
	
	public int delete(String nameSpace) {
		return getSqlSession().delete(nameSpace);
	}

	public <T> T queryForObject(String nameSpace) {
		return getSqlSession().selectOne(nameSpace);
	}

/*	*//**
	 * 
	 * 
	 * @param nameSpace
	 * @param whereParams
	 * @param rowBounds
	 * @return
	 *//*
	public <T> List<T> queryForListPagination(String nameSpace, Object whereParams, RowBounds rowBounds) {
		return getSqlSession().selectList(nameSpace, whereParams, rowBounds);
	}
*/
	public <T> List<T> queryForList(String nameSpace, Object whereParams) {
		return getSqlSession().selectList(nameSpace, whereParams);
	}

	public <T> List<T> queryForList(String nameSpace) {
		return getSqlSession().selectList(nameSpace);
	}

	public int insert(String nameSpace, Object entity) {
		return getSqlSession().insert(nameSpace, entity);
	}

	public <T> T queryForObject(String nameSpace, Object whereParams) {
		return getSqlSession().selectOne(nameSpace, whereParams);
	}
	
	public <K, V> Map<K, V> queryForMap(String nameSpace, Object whereParams, String mapKey) {
		return getSqlSession().selectMap(nameSpace, whereParams, mapKey);
	}
}
