package com.example.pbbackend.model;

import javax.persistence.*;

@Entity
@Table(name="streak")
public class Streak {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "streakId")
    private Integer streakId;
    private Integer numDays;
    //"yyyy MM dd"
    private String dateStreakAdapted;
    private String tag;
    /*@ManyToMany(targetEnTtity = User.class)
    @JoinColumn(name = "accountId", nullable = false)*/
    private Integer accountId;

    public Integer getStreakId() {
        return streakId;
    }

    public void setStreakId(Integer streakId) {
        this.streakId = streakId;
    }

    public Integer getNumDays() {
        return numDays;
    }

    public void setNumDays(Integer numDays) {
        this.numDays = numDays;
    }

    public String getDateStreakAdapted() {
        return dateStreakAdapted;
    }

    public void setDateStreakAdapted(String dateStreakAdapted) {
        this.dateStreakAdapted = dateStreakAdapted;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
