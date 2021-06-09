package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "Welcome to the posts index page!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsId(@PathVariable int id) {
        return "This is your ID: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate() {
        return "You will be able to create posts from this page, please come back when its finally done!";
    }
}
