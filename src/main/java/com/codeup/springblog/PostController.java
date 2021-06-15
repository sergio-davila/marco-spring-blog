package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

//    @PostMapping("/posts/create")
//    public String postsCreate(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        @PostMapping("/posts/create")
        public String postsCreate(@ModelAttribute Post post) {
        User user = userDao.getById(1L);
        Post newPost = new Post(post.getTitle(), post.getBody(), user, null);

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

//    @PostMapping("/posts/edit/{id}")
//    public String postsEdit(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body, @RequestParam(name = "imageURL") String imageURL, @RequestParam(name = "imageDescription") String imageDescription) {
        @PostMapping("/posts/edit/{id}")
        public String postsEdit(@PathVariable long id, @ModelAttribute Post post, @RequestParam(name = "imageURL") String imageURL, @RequestParam(name = "imageDescription") String imageDescription) {

//        PostImage image1 = new PostImage("https://i.ytimg.com/vi/ggNCKiu7nhA/maxresdefault.jpg", "60 in tv", post);
//        PostImage image2 = new PostImage("https://i.rtings.com/assets/products/mrQV6IMB/samsung-q60-q60t-qled/design-small.jpg", "60 in tv train", post);
        PostImage image1 = new PostImage(imageURL, imageDescription, post);
        List<PostImage> images = new ArrayList<>();
        images.add(image1);
        post.setImages(images);

        postDao.save(post);

        return "redirect:/posts";
    }
}
