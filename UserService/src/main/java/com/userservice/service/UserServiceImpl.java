package com.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.userservice.dao.UserDao;
import com.userservice.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ctl.dcma.service.UserService#addUser(com.ctl.dcma.model.User)
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public boolean addUser(User user) {
		return userDao.addUser(user);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ctl.dcma.service.UserService#getAllUsers()
	 */
	public List<User> getAllUsers() {

		return userDao.getAllUsers();
	}

	@Override
	public User findUser(int userId) {
		return userDao.findUser(userId);
	}

}
