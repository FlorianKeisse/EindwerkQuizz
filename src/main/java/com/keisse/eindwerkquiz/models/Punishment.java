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
public class Punishment {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    private String punishmentTask;

    public Punishment() {
    }


}
