package org.myproject.web.validation;


import org.myproject.repository.entity.User;
import org.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * FormValidator  - class for validating filled fields
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors err) {
//        ValidationUtils.rejectIfEmpty(err, "fullName", "reg.user.fullName.empty");
        User user = (User) obj;

        if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())) {
            err.rejectValue("confirmPassword", "reg.user.passwordsNotMatch","passwords not match");
        }

        //if (userService.getByEmail(user.getEmail()) != null) {
        if (userService.isEmailExist(user.getEmail())) {
            err.rejectValue("email", "reg.user.email.alreadyExists", "email already exist");
        }
    }

}


