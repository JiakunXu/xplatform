package com.hsh24.xplatform.user.dao;

import com.hsh24.xplatform.api.user.bo.User;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IUserDao {

	/**
	 * 
	 * @param passport
	 * @return
	 */
	User getUserByPassport(String passport);

	/**
	 * 
	 * @param user
	 * @return
	 */
	int updateUser(User user);

}
