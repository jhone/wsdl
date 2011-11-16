package com.redsun.platf.dao.account;

import org.springframework.stereotype.Component;

import com.redsun.platf.dao.base.impl.PagedDao;
import com.redsun.platf.entity.account.User;

/**
 * 用户对象的泛型DAO类.
 * 
 * @author calvin
 */
@Component
public class UserDao extends PagedDao<User, Long> {

	public UserDao() {
		super();
		this.entityClass=User.class;
	}
	
}
