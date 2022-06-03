package com.example.jeezoo.fight.infrastructure;

import lombok.Getter;

import javax.persistence.*;

@Entity(name = "fights")
@Getter
public class FightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    public FightEntity id(Long id) {
        this.id = id;
        return this;
    }

    public FightEntity title(String title) {
        this.title = title;
        return this;
    }
}
