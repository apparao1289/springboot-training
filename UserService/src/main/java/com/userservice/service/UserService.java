package com.userservice.service;

import java.util.List;

import com.userservice.entity.User;

public interface UserService {

	/**
	 * Adds the user.
	 * 
	 * @param user the user
	 * @return true, if successful
	 */
	boolean addUser(User user);

	/**
	 * Gets the all users.
	 * 
	 * @return the all users
	 */
	List<User> getAllUsers();

	/**
	 * Find user.
	 * 
	 * @param userId the user id
	 * @return the user
	 */
	User findUser(int userId);

}
