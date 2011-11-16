package com.redsun.platf.dao.sys;

import org.springframework.stereotype.Repository;

import com.redsun.platf.dao.base.impl.PagedDao;
import com.redsun.platf.entity.sys.SystemLanguage;

@Repository
public class SystemLanguageDao extends PagedDao<SystemLanguage, Long> {

	public SystemLanguageDao() {
		super();
		this.entityClass = SystemLanguage.class;
	}

}
