package com.example.instagram.model;

public class Post {
    private String postid;
    private String postimage;
    private String description;
    private String publisher;

    public Post(String postid, String postImage, String description, String publisher) {
        this.postid = postid;
        this.postimage = postImage;
        this.description = description;
        this.publisher = publisher;
    }

    public Post() {
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPostImage() {
        return postimage;
    }

    public void setPostImage(String postImage) {
        this.postimage = postImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
