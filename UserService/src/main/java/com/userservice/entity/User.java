package com.userservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id", length = 10)
    private int userId;

    @Column(name = "user_name", length = 20)
    private String userName;

    @Column(name = "role", length = 20)
    private String role;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
