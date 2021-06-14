package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;


    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String showAllPosts(Model model) {
//        List<Post> listOfPosts = new ArrayList<>();
//        listOfPosts.add(new Post("TV", "60 inch tv"));
//        listOfPosts.add(new Post("Laptop", "Gaming laptop"));
//        model.addAttribute("posts", listOfPosts);

        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePostPage(@PathVariable long id, Model model) {
//        Post post = new Post("TV", "60 inch tv");
//        model.addAttribute("singlePost", adDao.findByTitle());
//        model.addAttribute("singlePost", postDao.findByTitle("TV"));
        model.addAttribute("singlePost", postDao.getById(id));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsCreate(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        User user = userDao.getById(1L);
        Post newPost = new Post(title, body, user);
        Post savedPost = postDao.save(newPost);
        return "redirect:/posts/" + savedPost.getId();
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
