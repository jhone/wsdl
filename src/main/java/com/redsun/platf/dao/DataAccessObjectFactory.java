package com.redsun.platf.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.redsun.ims.entity.StorageStation;
import com.redsun.platf.dao.account.RoleDao;
import com.redsun.platf.dao.base.IPagedDao;
import com.redsun.platf.dao.sys.SystemCompanyDao;
import com.redsun.platf.dao.sys.SystemConfigurationDao;
import com.redsun.platf.entity.account.Authority;
import com.redsun.platf.entity.account.User;
import com.redsun.platf.entity.sys.SystemLanguage;
import com.redsun.platf.entity.sys.SystemTheme;
import com.redsun.platf.entity.sys.SystemValue;

/**
 * <p>Title        : com.webapp        </p>
 * <p>Description  :   所有DAO的集合                </p>
 * <p>Copyright    : Copyright (c) 2011</p>
 * <p>Company      : FreedomSoft       </p>
 * 
 */

/**
 * @author dick pan
 * @version 1.0
 * @since 1.0
 *        <p>
 *        <H3>Change history</H3>
 *        </p>
 *        <p>
 *        2011/1/25 : Created
 *        </p>
 * 
 */
@Component
// @Transactional //need't just in dao
public class DataAccessObjectFactory implements Serializable {

	private static final long serialVersionUID = -5450000925993172262L;
	private static DataAccessObjectFactory instance;

	public static DataAccessObjectFactory getInstance() {
		if (instance == null)
			instance = new DataAccessObjectFactory();
		return instance;
	}

	// authority
	@Resource
	// (name = "systemLanguageDao")
	private IPagedDao<SystemLanguage, Long> systemLanguageDao;

	// authority
	@Resource
	// (name = "systemThemeDao")
	private IPagedDao<SystemTheme, Long> systemThemeDao;
	// private SystemThemeDao systemThemeDao;

	@Resource
	// (name = "systemValueDao")
	private IPagedDao<SystemValue, Long> systemValueDao;

	// @Resource
	private IPagedDao<Authority, Long> authorityDao;

	// role
	// @Resource
	private IPagedDao<RoleDao, Long> roleDao;

	// user
	// @Resource
	private IPagedDao<User, Long> userDao;
	// @Resource
	private SystemConfigurationDao systemConfigurationDao;
	// @Resource
	private SystemCompanyDao systemCompanyDao;

	// //ims dao
	@Resource
	private IPagedDao<StorageStation, Long> storageStationDao;

	public IPagedDao<StorageStation, Long> getStorageStationDao() {
		return storageStationDao;
	}

	public SystemCompanyDao getSystemCompanyDao() {
		return systemCompanyDao;
	}

	public SystemConfigurationDao getSystemConfigurationDao() {
		return systemConfigurationDao;
	}

	public IPagedDao<SystemLanguage, Long> getSystemLanguageDao() {
		return systemLanguageDao;
	}

	public IPagedDao<SystemTheme, Long> getSystemThemeDao() {
		// error // public SystemThemeDao getSystemThemeDao() {
		return systemThemeDao;
	}

	public IPagedDao<SystemValue, Long> getSystemValueDao() {
		return systemValueDao;
	}

	public IPagedDao<Authority, Long> getAuthorityDao() {
		return authorityDao;
	}

	public IPagedDao<RoleDao, Long> getRoleDao() {
		return roleDao;
	}

	public IPagedDao<User, Long> getUserDao() {
		return userDao;
	}

}
