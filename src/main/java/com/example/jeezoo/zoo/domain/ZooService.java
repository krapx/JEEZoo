package com.example.jeezoo.zoo.domain;

import java.util.Optional;

public interface ZooService {

    Zoo getZooById(ZooId zooId);
    ZooId addZoo(String name, ZooStatus zooStatus);

    Void deleteZoo(Long id);

    Void update(Long id, String name, String zooStatus);
}
