package com.example.jeezoo.zoo.domain;

import com.example.jeezoo.user.domain.model.UserId;

import java.util.Optional;

public interface ZooService {

    Zoo getZooById(ZooId zooId);
    ZooId addZoo(String name, ZooStatus zooStatus, UserId userId);
    Void deleteZoo(ZooId id);
    Void update(ZooId id, String name, ZooStatus zooStatus, UserId userId);
}
