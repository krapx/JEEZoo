package com.example.jeezoo.space.infrastructure;

import lombok.Getter;

import javax.persistence.*;

@Entity(name = "spaces")
@Getter
public class SpaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    public SpaceEntity id(Long id) {
        this.id = id;
        return this;
    }

    public SpaceEntity title(String title) {
        this.title = title;
        return this;
    }
}
