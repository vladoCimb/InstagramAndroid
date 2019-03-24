package com.example.instagram.model;

public class User {

    private String id;
    private String username;
    private String fullname;
    private String bio;
    private String imageUrl;

    public User(String id, String username, String fullname, String bio,String imageUrl) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.bio = bio;
        this.imageUrl = imageUrl;
    }

    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
