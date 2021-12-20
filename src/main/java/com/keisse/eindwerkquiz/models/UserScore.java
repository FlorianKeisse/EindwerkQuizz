package com.keisse.eindwerkquiz.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Setter


@ToString
@Entity
public class UserScore {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String themeName;

    private String punishmentLow;
    private String punishmentMedium;
    private String punishmentHigh;

    private int total;
    private int score;

    public UserScore() {
    }

    public UserScore(String username, String themeName, String punishmentLow, String punishmentMedium, String punishmentHigh, int total, int score) {
        this.username = username;
        this.themeName = themeName;
        this.punishmentLow = punishmentLow;
        this.punishmentMedium = punishmentMedium;
        this.punishmentHigh = punishmentHigh;
        this.total = total;
        this.score = score;
    }
}
