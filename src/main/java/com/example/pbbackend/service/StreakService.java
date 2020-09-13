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

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;


@Service
public class StreakService {

    private StreakRepository streakRepository;

    @Autowired
    public StreakService(StreakRepository streakRepository) {
        this.streakRepository=streakRepository;
    }

    public Streak findStreakByStreakId(Integer streakId) {
        return streakRepository.findByStreakId(streakId);
    }

    public Streak findStreakByAccountId(Integer accountId) {
        return streakRepository.findByAccountId(accountId);
    }

    public Streak saveStreak(Streak streak) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDateTime now = LocalDateTime.now();
        streak.setDateStreakAdapted(dtf.format(now));
        streakRepository.save(streak);
        return streak;
    }
}
