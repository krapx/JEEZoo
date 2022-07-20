package com.example.jeezoo.zoo.domain;

import com.example.jeezoo.player.domain.model.PlayerId;

import java.time.LocalDateTime;

public interface ZooService {

    Zoo getZooById(ZooId zooId);
    ZooId addZoo(String name, ZooStatus zooStatus, PlayerId playerId);
    Void deleteZoo(ZooId id);
    Void update(ZooId id, String name, ZooStatus zooStatus, LocalDateTime createdAt, PlayerId playerId);
}
