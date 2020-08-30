package com.userservice.form;

import java.util.List;

import com.userservice.entity.User;

/**
 * The Class UserForm.
 */
public class UserForm {
    
    /** The user id. */
    private Integer userId;
    
    /** The user name. */
    private String userName;
    
    /** The role. */
    private String role;
    
    /** The user list. */
    private List<User> userList;

    /**
     * Gets the user id.
     * 
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     * 
     * @param userId the new user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the user name.
     * 
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     * 
     * @param userName the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the role.
     * 
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role.
     * 
     * @param role the new role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the user list.
     * 
     * @return the user list
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * Sets the user list.
     * 
     * @param userList the new user list
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
