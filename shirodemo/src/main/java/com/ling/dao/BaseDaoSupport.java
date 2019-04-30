package com.ling.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
* @ClassName: BaseDaoSupport
* @Description: TODO
* @author owen.he
* @date Dec 21, 2017 9:38:00 AM
*
*/
public abstract class BaseDaoSupport extends SqlSessionDaoSupport  {

	/**
	 * 
	 */
	public BaseDaoSupport() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	@Qualifier(value = "sqlSessionTemplate")
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

}
