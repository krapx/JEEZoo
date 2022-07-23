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
    private String status;
    private Long zooId;
    private int defeatedCount;

    public SpaceEntity id(Long id) {
        this.id = id;
        return this;
    }

    public SpaceEntity name(String name) {
        this.name = name;
        return this;
    }

    public SpaceEntity status(String status) {
        this.status = status;
        return this;
    }

    public SpaceEntity zooId(Long zooId) {
        this.zooId = zooId;
        return this;
    }

    public SpaceEntity defeatedCount(int defeatedCount) {
        this.defeatedCount = defeatedCount;
        return this;
    }
}
