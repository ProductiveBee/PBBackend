package com.example.pbbackend.service;

import com.example.pbbackend.model.StreakPost;
import com.example.pbbackend.repository.StreakPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StreakPostService {

    @Autowired
    private StreakPostRepository streakPostRepository;

    @Autowired
    public StreakPostService(StreakPostRepository streakPostRepository) {
        this.streakPostRepository=streakPostRepository;
    }

    StreakPost findPostByPostId(Integer postId){
        return streakPostRepository.findByPostId(postId);

    }
    StreakPost findPostByName(String name){
        return streakPostRepository.findByName(name);

    }
    StreakPost findPostByStreakId(Integer streakId){
        return streakPostRepository.findByStreakId(streakId);
    }


    public StreakPost saveStreakPost(StreakPost streakPost) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDateTime now = LocalDateTime.now();
        streakPost.setDate(dtf.format(now));
        streakPostRepository.save(streakPost);
        return streakPost;
    }
}
