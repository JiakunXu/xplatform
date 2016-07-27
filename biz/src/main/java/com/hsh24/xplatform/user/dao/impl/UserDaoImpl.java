package com.hsh24.xplatform.user.dao.impl;

import com.hsh24.xplatform.api.user.bo.User;
import com.hsh24.xplatform.framework.dao.impl.BaseDaoImpl;
import com.hsh24.xplatform.user.dao.IUserDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	@Override
	public User getUserByPassport(String passport) {
		return (User) getSqlMapClientTemplate().queryForObject("user.getUserByPassport", passport);
	}

	@Override
	public int updateUser(User user) {
		return getSqlMapClientTemplate().update("user.updateUser", user);
	}

}
