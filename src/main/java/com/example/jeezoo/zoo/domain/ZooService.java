package com.example.jeezoo.zoo.domain;

public interface ZooService {

    ZooId addZoo(String name, String location, Float size, String spaceCapacity,
                 String peopleCapacity, ZooStatus zooStatus);

    Void deleteZoo(Long id);

    Void update(Long id, String name, String location, Float size, String spaceCapacity,
                String peopleCapacity, String zooStatus);
}
