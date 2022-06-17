package com.example.jeezoo.zoo.domain;

public interface ZooService {

    ZooId addZoo(String name, ZooStatus zooStatus);

    Void deleteZoo(Long id);

    Void update(Long id, String name, String zooStatus);
}
