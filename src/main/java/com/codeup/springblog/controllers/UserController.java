package com.codeup.springblog.controllers;

import com.codeup.springblog.DAOs.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private UserRepository users;
//    private PasswordEncoder passwordEncoder;
//
//    public UserController(UserRepository users, PasswordEncoder passwordEncoder) {
//        this.users = users;
//        this.passwordEncoder = passwordEncoder;
//    }

    @GetMapping("/sign-up")
    public String showSignUpForm(Model model) {
        model.addAttribute()
    }

//    @GetMapping("/users/all")
//    public String getAllUsers() {
//        return "users";
//    }
//
//    @GetMapping("/user")
//    @ResponseBody
//    public String getTheStringUser(){
//        return "users";
//    }
}
