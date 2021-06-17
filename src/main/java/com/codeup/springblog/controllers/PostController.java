package com.codeup.springblog.controllers;

import com.codeup.springblog.DAOs.PostRepository;
import com.codeup.springblog.DAOs.UserRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostImage;
import com.codeup.springblog.models.User;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.services.StringService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private EmailService emailService;
    private final PostRepository postDao;
    private final UserRepository userDao;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String showAllPosts(Model model) {

        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePostPage(@PathVariable long id, Model model) {
        model.addAttribute("singlePost", postDao.getById(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsCreate(@ModelAttribute Post post) {
//        User user = userDao.getById(1L);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);

        Post savedPost = postDao.save(post);

        emailService.prepareAndSend(post, "new post created", post.getBody());

        return "redirect:/posts/" + savedPost.getId();
    }

    @PostMapping("/posts/delete/{id}")
    public String postsDelete(@PathVariable Long id) {

        postDao.deleteById(id);

        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String postsEditPage(@PathVariable long id, Model model) {

        Post post = postDao.getById(id);

        model.addAttribute("post", post);

        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String postsEdit(@PathVariable long id, @ModelAttribute Post post, @RequestParam(name = "imageURL") String imageURL, @RequestParam(name = "imageDescription") String imageDescription) {
        PostImage image1 = new PostImage(imageURL, imageDescription, post);
        List<PostImage> images = new ArrayList<>();
        images.add(image1);
        post.setImages(images);

        postDao.save(post);

        return "redirect:/posts";
    }
}
