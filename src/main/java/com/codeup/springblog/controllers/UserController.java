package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/users/all")
    public String getAllUsers() {
        return "users";
    }

    @GetMapping("/user")
    @ResponseBody
    public String getTheStringUser(){
        return "users";
    }
}
