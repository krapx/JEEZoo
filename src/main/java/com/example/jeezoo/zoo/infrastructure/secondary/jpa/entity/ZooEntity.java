package com.example.jeezoo.zoo.infrastructure.secondary.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "zoos")
@AllArgsConstructor
@Getter
public class ZooEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String zooStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long playerId;

    public ZooEntity() {
    }
}
