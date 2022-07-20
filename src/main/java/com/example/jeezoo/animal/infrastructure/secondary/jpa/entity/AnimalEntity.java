package com.example.jeezoo.animal.infrastructure.secondary.jpa.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Animals")
@AllArgsConstructor
@Getter
public final class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String status;
    private float lengthMax;
    private float weightMax;
    private LocalDate arrivalDate;
    private String imageLink;
    private Long spaceId;

    public AnimalEntity() {
    }
}
