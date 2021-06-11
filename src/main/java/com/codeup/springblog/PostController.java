package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {



    @GetMapping("/posts")
    public String posts(
            Model model
    ) {
        List<Post> listOfPosts = new ArrayList<>();
        listOfPosts.add(new Post("TV", "60 inch tv"));
        listOfPosts.add(new Post("Laptop", "Gaming laptop"));
        model.addAttribute("posts", listOfPosts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(
            @PathVariable int id,
            Model model
    ) {
        Post post = new Post("TV", "60 inch tv");
        model.addAttribute("singlePost", post);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate() {
        return "You will be able to create posts from this page, please come back when its finally done!";
    }
}
