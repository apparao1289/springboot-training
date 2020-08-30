package com.userservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.userservice.entity.User;
import com.userservice.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ctl.dcma.dao.UserDao#addUser(com.ctl.dcma.model.User)
	 */
	public boolean addUser(User user) {

		userRepository.save(user);

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ctl.dcma.dao.UserDao#getAllUsers()
	 */
	public List<User> getAllUsers() {

		List<User> userList = userRepository.findAll();

		return userList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.apparao.sample.dao.UserDao#findUser(int)
	 */
	public User findUser(int userId) {

		Optional<User> user = userRepository.findById(userId);

		return user.get();
	}

}
