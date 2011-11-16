package com.redsun.platf.dao.sys;

import org.springframework.stereotype.Component;

import com.redsun.platf.dao.base.impl.PagedDao;
import com.redsun.platf.entity.sys.SystemCompany;

/**
 * 用户对象的泛型DAO类.
 * 
 * @author calvin
 */
@Component
public class SystemCompanyDao extends PagedDao<SystemCompany, Long> {

	public SystemCompanyDao() {
		super();
		this.entityClass = SystemCompany.class;
	}

}
