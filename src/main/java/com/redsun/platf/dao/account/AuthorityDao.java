package com.redsun.platf.dao.account;

import org.springframework.stereotype.Component;

import com.redsun.platf.dao.base.impl.PagedDao;
import com.redsun.platf.entity.account.Authority;

/**
 * 授权对象的泛型DAO.
 * 
 * @author calvin
 */
@Component
public class AuthorityDao extends PagedDao<Authority, Long> {
	public AuthorityDao() {
		super();
		this.entityClass=Authority.class;
	}

}
