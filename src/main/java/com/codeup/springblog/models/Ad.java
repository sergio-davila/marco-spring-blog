//package com.codeup.springblog;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="ads")
//public class Ad {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(nullable = false, length = 100)
//    private String title;
//
//    @Column(nullable = false)
//    private String description;
//
//    @OneToOne
//    private User owner;
//
//    public Ad() {
//    }
//
//    public Ad(long id, String title, String description, User owner) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.owner = owner;
//    }
//
//    public Ad(String title, String description, User owner) {
//        this.title = title;
//        this.description = description;
//        this.owner = owner;
//    }
//
//    public Ad(String title, String description) {
//        this.title = title;
//        this.description = description;
//    }
//
//    public Ad(long id, String title, String description) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }
//}
