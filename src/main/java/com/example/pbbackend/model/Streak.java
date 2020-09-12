package com.example.pbbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="streak")
public class Streak {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "streakId")
    private Integer streakId;
    private Integer numDays;
    private Timestamp dateStreakAdapted;
    private String tag;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "name", nullable = false)
    private String name;

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

    public Timestamp getDateStreakAdapted() {
        return dateStreakAdapted;
    }

    public void setDateStreakAdapted(Timestamp dateStreakAdapted) {
        this.dateStreakAdapted = dateStreakAdapted;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setAccount_id(String name) {
        this.name = name;
    }
}
