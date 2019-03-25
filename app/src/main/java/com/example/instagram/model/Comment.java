package com.example.instagram.model;

public class Comment {
    private String comment;
    private String publisher;

    public Comment(String comment, String publisher) {
        this.comment = comment;
        this.publisher = publisher;
    }

    public String getComment() {
        return comment;
    }

    public Comment() {
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String pubisher) {
        this.publisher = publisher;
    }
}
