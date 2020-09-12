package com.example.pbbackend.model;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Integer post_id;
    private String postTitle;
    private String postContent;
    private String date;
    private String tag;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "account_id", nullable = false)
    private Integer account_id;

    public Post(String postTitle, String postContent, String date, String tag, Integer account_id) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.date = date;
        this.tag = tag;
        this.account_id = 1;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }
}
