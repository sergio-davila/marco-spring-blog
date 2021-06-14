package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository adDao) {
        this.postDao = adDao;
    }

    @GetMapping("/posts")
    public String posts(
            Model model
    ) {
//        List<Post> listOfPosts = new ArrayList<>();
//        listOfPosts.add(new Post("TV", "60 inch tv"));
//        listOfPosts.add(new Post("Laptop", "Gaming laptop"));
//        model.addAttribute("posts", listOfPosts);

        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(
            @PathVariable int id,
            Model model
    ) {
//        Post post = new Post("TV", "60 inch tv");
//        model.addAttribute("singlePost", adDao.findByTitle());
        model.addAttribute("singlePost", postDao.findByTitle("TV"));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate() {
        return "You will be able to create posts from this page, please come back when its finally done!";
    }

    @PostMapping("/posts/delete/{n}")
    public String postsDelete(@PathVariable Long n) {

        postDao.deleteById(n);

        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String postsEditPage(@PathVariable long id, Model model) {

        Post post = postDao.getById(id);

        model.addAttribute("post", post);

        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String postsEdit(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {

        Post post = postDao.getById(id);
        post.setTitle(title);
        post.setBody(body);

        postDao.save(post);

        return "redirect:/posts";
    }
}
