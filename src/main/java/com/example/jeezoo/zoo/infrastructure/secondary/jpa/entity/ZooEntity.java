package com.example.jeezoo.zoo.infrastructure.secondary.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Zoos")
@AllArgsConstructor
@Getter
public class ZooEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long zooId;
    private String name;
    private String location;
    private Float size;
    private String spaceCapacity;
    private String peopleCapacity;
    private String zooStatus;

    public ZooEntity() {

    }
}
