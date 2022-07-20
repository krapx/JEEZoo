package com.example.jeezoo.userAnimal.infrastructure.secondary;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "user_animals")
@Data
@AllArgsConstructor
public final class UserAnimalEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Long damage;
    private String name;
    private String image;
    private LocalDateTime creationAt;
    private LocalDateTime updatedAt;
    private Long userId;
    private Long zooId;

    public UserAnimalEntity() {
    }
}