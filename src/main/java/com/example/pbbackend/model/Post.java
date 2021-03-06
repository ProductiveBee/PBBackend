package com.example.pbbackend.model;

import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Integer postId;
    @NotEmpty(message = "*Please provide Title for the post")
    private String postTitle;
    private String postContent;
    private String date;
    private String tag;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "accountId", nullable = false)
    private Integer accountId;

    public Post(String postTitle, String postContent, String date, String tag, Integer account_id) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.date = date;
        this.tag = tag;
        this.accountId = 1;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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
        return accountId;
    }

    public void setAccount_id(Integer account_id) {
        this.accountId = account_id;
    }
}
