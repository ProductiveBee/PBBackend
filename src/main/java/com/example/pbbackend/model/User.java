package com.example.pbbackend.model;

import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name="account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_id")
    private Integer account_id;
    private String name;
    private String password;
    private String email;
    private Integer score;
    //current streak
    private Integer streak;
//    private Integer numOfDays;



    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

//    public Integer getNumOfDays() {
//        return numOfDays;
//    }
//
//    public void setNumOfDays(Integer numOfDays) {
//        this.numOfDays = numOfDays;
//    }

}
