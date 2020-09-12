package com.example.pbbackend.repository;

import com.example.pbbackend.model.Streak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreakRepository extends JpaRepository<Streak, Integer> {
    Streak findByStreakId(Integer streakId);
    Streak findByName(String userName);
}
