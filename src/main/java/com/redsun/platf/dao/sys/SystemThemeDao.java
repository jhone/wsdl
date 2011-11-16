package com.redsun.platf.dao.sys;

import org.springframework.stereotype.Component;

import com.redsun.platf.dao.base.impl.PagedDao;
import com.redsun.platf.entity.sys.SystemTheme;

/**
 * 用户对象的泛型DAO类.
 * 
 * @author calvin
 */
@Component
public class SystemThemeDao extends PagedDao<SystemTheme, Long> {

	public SystemThemeDao() {
		super();
		this.entityClass=SystemTheme.class;
	}
	
}
