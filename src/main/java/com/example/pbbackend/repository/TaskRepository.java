package com.example.pbbackend.repository;

import com.example.pbbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}


