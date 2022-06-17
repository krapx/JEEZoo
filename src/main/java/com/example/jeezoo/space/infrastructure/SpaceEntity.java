package com.example.jeezoo.space.infrastructure;

import lombok.Getter;

import javax.persistence.*;

@Entity(name = "spaces")
@Getter
public class SpaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public SpaceEntity id(Long id) {
        this.id = id;
        return this;
    }

    public SpaceEntity name(String name) {
        this.name = name;
        return this;
    }
}
