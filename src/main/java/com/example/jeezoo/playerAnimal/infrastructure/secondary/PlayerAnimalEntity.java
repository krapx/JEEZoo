package com.example.jeezoo.playerAnimal.infrastructure.secondary;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "player_animals")
@Data
@AllArgsConstructor
public final class PlayerAnimalEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Long damage;
    private String name;
    private String image;
    private LocalDateTime creationAt;
    private LocalDateTime updatedAt;
    private Long playerId;
    private Long zooId;

    public PlayerAnimalEntity() {
    }
}