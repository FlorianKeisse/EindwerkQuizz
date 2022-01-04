package com.keisse.eindwerkquiz.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private String punishment;
    private String punishment1;
    private String punishment2;
    private String punishment3;
    private String punishment4;
    private String punishment5;

    private int total;
    private int score;

    @OneToOne
    private User user;

    public UserScore() {
    }

    public UserScore(String username, String themeName, String punishment, int total, int score) {
        this.username = username;
        this.themeName = themeName;
        this.punishment = punishment;

        this.total = total;
        this.score = score;
    }
}
