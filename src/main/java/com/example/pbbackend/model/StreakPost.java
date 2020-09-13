package com.example.pbbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="streakpost")
public class StreakPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postId")
    private Integer postId;
    @NotEmpty(message = "*Please provide Title for the post")
    private String postTitle;
    private String postContent;
    private String date;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "accountId", nullable = false)
    private String name;
    @ManyToOne(targetEntity = Streak.class)
    @JoinColumn(name = "streakId", nullable = false)
    private Integer streakId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStreakId() {
        return streakId;
    }

    public void setStreakId(Integer streakId) {
        this.streakId = streakId;
    }
}


