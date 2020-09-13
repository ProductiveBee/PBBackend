package com.example.pbbackend.repository;

import com.example.pbbackend.model.StreakPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StreakPostRepository extends JpaRepository<StreakPost, Integer> {
    StreakPost findByPostId(Integer postId);
    StreakPost findByName(String name);
    StreakPost findByStreakId(Integer streakId);
}
