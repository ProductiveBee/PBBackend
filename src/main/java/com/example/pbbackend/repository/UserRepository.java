package com.example.pbbackend.repository;

import com.example.pbbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByName(String userName);
//    User findByUserId(Integer account_id);
}
