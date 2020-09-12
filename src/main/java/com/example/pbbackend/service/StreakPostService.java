package com.example.pbbackend.service;

import com.example.pbbackend.model.Streak;
import com.example.pbbackend.model.StreakPost;
import com.example.pbbackend.repository.StreakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreakPostService {

    private StreakRepository streakRepository;

    @Autowired
    public StreakPostService(StreakRepository streakRepository) {
        this.streakRepository=streakRepository;
    }

    public Streak findStreakByStreakId(Integer streakId) {
        return streakRepository.findByStreakId(streakId);
    }

    public Streak findStreakByName(String name) {
        return streakRepository.findByName(name);
    }

    public StreakPost saveStreakPost(StreakPost streakPost) {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        return streakPost;
    }
}
