package com.example.jeezoo.zooBreak.infrastructure;

import lombok.Getter;

import javax.persistence.*;

@Entity(name = "zooBreaks")
@Getter
public class ZooBreakEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    public ZooBreakEntity id(Long id) {
        this.id = id;
        return this;
    }

    public ZooBreakEntity title(String title) {
        this.title = title;
        return this;
    }
}
