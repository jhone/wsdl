package com.redsun.platf.unit.dao.account;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springside.modules.test.spring.SpringTxTestCase;

import com.redsun.platf.dao.base.IPagedDao;
import com.redsun.platf.data.AccountData;
import com.redsun.platf.entity.account.Authority;
import com.redsun.platf.entity.account.Role;
import com.redsun.platf.entity.account.User;

/**
 * UserDao的测试用例, 测试ORM映射及特殊的DAO操作.
 * 
 * 默认在每个测试函数后进行回滚.
 * 
 * @author calvin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class UserDaoTest extends SpringTxTestCase {
	private static DataSource dataSourceHolder = null;
	@Resource
	private IPagedDao<Authority, Long> authorityDao;
	@Resource//(name="roleDao")
	private IPagedDao<Role, Long>  roleDao;

	@Resource//(name="userDao")
	private IPagedDao<User, Long> userDao;


	@Before
	public void loadDefaultData() throws Exception {
//		if (dataSourceHolder == null) {
//			DbUnitUtils.loadData(dataSource, "/data/default-data.xml");
//			dataSourceHolder = dataSource;
//		}
	}

	@AfterClass
	public static void cleanDefaultData() throws Exception {
//		DbUnitUtils.removeData(dataSourceHolder, "/data/default-data.xml");
	}

	@Test
	// 如果你需要真正插入数据库,将Rollback设为false
	// @Rollback(false)
	public void crudEntityWithRole() {
		
//		Authority authority = AccountData.getRandomAuthority();
//		authorityDao.save(authority);
//		
//		// 强制执行sql语句
//		authorityDao.flush();

		//add role with authority
//		Role role = new Role();
//		role.setName(DataUtils.randomName("Role"));
		
		Role role=AccountData.getRandomDefaultRole();
//		role.getAuthorityList().add(authority);
		
		roleDao.save(role);
		roleDao.flush();

		//add user with role
		/*role must saved before */
		// 新建并保存带角色的用户
//		User user = AccountData.getRandomUserWithRole();
		User user = AccountData.getRandomUser();
		user.getRoleList().add(role);
		userDao.save(user);
		// 强制执行sql语句
		userDao.flush();

		// 获取用户
		user = userDao.findUniqueBy("id", user.getId());
		assertEquals(1, user.getRoleList().size());

		
		// 删除用户的角色
//		roleDao.delete(role);
//		roleDao.flush();
		
		user.getRoleList().remove(0);
//		userDao.saveOrUpdate(user);//needn't
		userDao.flush();
		user = userDao.findUniqueBy("id", user.getId());
		assertEquals(0, user.getRoleList().size());
//
//		// 删除用户
		userDao.delete(user.getId());
		userDao.flush();
		user = userDao.findUniqueBy("id", user.getId());
		assertNull(user);
		//didn't delete from role
		role = roleDao.findUniqueBy("id", role.getId());
		System.out.println(role.getName());
		assertNotNull(role);
		
	}

	// 期望抛出ConstraintViolationException的异常.
	@Test(expected = org.hibernate.exception.ConstraintViolationException.class)
	public void savenUserNotUnique() {
		User user = AccountData.getRandomUser();
		user.setLoginName("admin");
		userDao.save(user);
		userDao.flush();
	}
}