package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring Boot to my friends in Marco!";
    }

//    @GetMapping("/hello")
//    @ResponseBody
//    public String helloName(@PathVariable String name) {
//        return "Hello from Spring Boot to my friends in Marco!";
//    }

    @GetMapping("hello/{name}")
    public String hello(
            @PathVariable String name,
            Model model
    ) {

        String bio = "Coolest dude ever";
        model.addAttribute("UsersName", name);
        model.addAttribute("bio", bio);

        return "helloUser";
    }


}
