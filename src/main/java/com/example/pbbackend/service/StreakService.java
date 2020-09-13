package com.example.pbbackend.service;

import com.example.pbbackend.model.Role;
import com.example.pbbackend.model.Streak;
import com.example.pbbackend.model.StreakPost;
import com.example.pbbackend.model.User;
import com.example.pbbackend.repository.RoleRepository;
import com.example.pbbackend.repository.StreakRepository;
import com.example.pbbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;


@Service
public class StreakService {

    private StreakRepository streakRepository;

    @Autowired
    public StreakService(StreakRepository streakRepository) {
        this.streakRepository=streakRepository;
    }

    public Streak findStreakByStreak_id(Integer streakId) {
        return streakRepository.findByStreakId(streakId);
    }

//    public Streak findStreakByName(String name) {
//        return streakRepository.findByName(name);
//    }

    public Streak saveStreak(Streak streak) {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        streak.setDateStreakAdapted(date);
        streakRepository.save(streak);
        return streak;
    }
}
