package com.example.pbbackend.repository;

import com.example.pbbackend.model.StreakPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StreakPostRepository extends JpaRepository<StreakPost, Integer> {
    StreakPost findBypostId(Integer postId);
    List<StreakPost> findByName(String name);
    List<StreakPost> findBystreakId(Integer streakId);
}
