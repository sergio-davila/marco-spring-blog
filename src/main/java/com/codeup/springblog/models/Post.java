package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="posts_categories",
            joinColumns={@JoinColumn(name = "post_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<PostCategory> categories;

    public Post() {
    }

    public Post(String title, String body, User user, List<PostImage> images, List<PostCategory> categories) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
        this.categories = categories;
    }

    public Post(long id, String title, String body, User user, List<PostImage> images, List<PostCategory> categories) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public List<PostCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<PostCategory> categories) {
        this.categories = categories;
    }
}
