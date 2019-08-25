package org.myproject.web.controller;

import org.myproject.repository.entity.User;
import org.myproject.repository.entity.enums.Role;
import org.myproject.service.UserService;
import org.myproject.web.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(value = "/reg")
public class RegistrationController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @RequestMapping( method = RequestMethod.GET)
    public String regForm(ModelMap model, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        model.addAttribute("newUser", new User());
        return "register";
    }

    @RequestMapping( method = RequestMethod.POST)
    public String regRequest(@Valid @ModelAttribute("newUser") User user, BindingResult result, ModelMap model) throws IOException {
        if(result.hasErrors()){
            return "register";
        }
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addNewUser(user);
        return "redirect:/login";
    }

}