package com.userservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.userservice.entity.User;
import com.userservice.form.UserForm;
import com.userservice.service.UserService;
import com.userservice.util.ExportExcelUtil;
import com.userservice.validator.UserValidator;

@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userForm") UserForm userForm, BindingResult result) {
		List<User> userList = null;
		try {
			logger.info("user id:" + userForm.getUserId());
			logger.info("user name:" + userForm.getUserName());
			logger.info("role:" + userForm.getRole());

			UserValidator.validate(userForm, result);
			if (result.hasErrors()) {
				return new ModelAndView("user", "userForm", userForm);
			} else {
				userService.addUser(getUser(userForm));
				userList = userService.getAllUsers();
				userForm.setUserList(userList);
				return new ModelAndView("userList", "userForm", userForm);
			}
		} catch (Exception e) {
			logger.error("Exception occurred in addUser::" + e.getMessage());
		}
		return null;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ModelAndView getUsers() {
		List<User> userList = null;
		try {
			UserForm userForm = new UserForm();
			userList = userService.getAllUsers();
			userForm.setUserList(userList);
			return new ModelAndView("userList", "userForm", userForm);
		} catch (Exception e) {
			logger.error("Exception occurred in getUsers::" + e.getMessage());
		}
		return null;
	}

	@RequestMapping(value = "/user")
	public ModelAndView newUser(@ModelAttribute("userForm") UserForm userForm) {
		return new ModelAndView("user", "userForm", new UserForm());
	}

	private User getUser(UserForm userForm) {
		User user = new User();
		if (userForm != null) {
			user.setUserId(userForm.getUserId());
			user.setUserName(userForm.getUserName());
			user.setRole(userForm.getRole());
		}
		return user;
	}

	@RequestMapping(value = "/upload")
	public ModelAndView upload(@ModelAttribute("userForm") UserForm userForm) {
		logger.info("upload method");
		return new ModelAndView("upload");
	}

	@RequestMapping(value = "/excel", method = RequestMethod.GET)
	public void exportToExcel(@ModelAttribute("userForm") UserForm userForm, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<User> userList = userService.getAllUsers();
			ExportExcelUtil.buildExcelDocument(userList, response);
		} catch (Exception e) {
			logger.error("Exception occurred in exportToExcel::" + e.getMessage());
		}

	}
}
