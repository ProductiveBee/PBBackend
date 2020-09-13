package com.example.pbbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="account")
public class User {

    @Id
    @Column(name="accountId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;
    @Column(name="name", unique = true)
    private String name;
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Value("${some.key:0}")
    private Integer score;
    //current streak
    @Value("${some.key:0}")
    private Integer streak;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Value("${some.key:{1}}")
    private Set<Role> roles;
//    private Integer numOfDays;
    @Value("${some.key:false}")
    @Column(name = "active")
    private Boolean active;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int account_id) {
        this.accountId = account_id;
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
