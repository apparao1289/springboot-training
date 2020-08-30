package com.userservice.validator;

import org.springframework.validation.Errors;

import com.userservice.form.UserForm;

public class UserValidator {
    public static void validate(UserForm userForm,Errors errors){
        if (userForm.getUserId() == null) {
            errors.rejectValue("userId","userId.mandatory", "User Id is Mandatory field");
        }
        if (userForm.getUserId() != null && userForm.getUserId() <= 0) {
            errors.rejectValue("userId","userId.invalid", "Invaild User Id.");
        }
        if (userForm.getUserName() == null || "".equalsIgnoreCase(userForm.getUserName())) {
            errors.rejectValue("userName", "userName.mandatory","User NAme is Mandatory Field");
        }
        if (userForm.getRole() == null || "".equalsIgnoreCase(userForm.getRole())) {
            errors.rejectValue("role", "role.mandatory","Role is Mandatory Field");
        }
    }
}
