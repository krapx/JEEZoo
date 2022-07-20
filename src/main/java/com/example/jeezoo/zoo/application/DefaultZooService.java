package com.example.jeezoo.zoo.application;

import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.zoo.domain.*;
import com.example.jeezoo.zoo.domain.exception.ZooNotFoundException;

import java.time.LocalDateTime;

public class DefaultZooService implements ZooService {

    private final Zoos zoos;

    public DefaultZooService(Zoos zoos) {
        this.zoos = zoos;
    }

    @Override
    public Zoo getZooById(ZooId zooId) {
        return zoos.findById(zooId).orElseThrow(() -> new ZooNotFoundException(zooId));
    }

    @Override
    public ZooId addZoo(String name, ZooStatus zooStatus, UserId userId) {
        Zoo zoo = Zoo.createZoo(name, zooStatus, userId);
        return zoos.save(zoo);
    }

    @Override
    public Void deleteZoo(ZooId id) {
        zoos.deleteById(id);
        return null;
    }

    @Override
    public Void update(ZooId id, String name, ZooStatus zooStatus, LocalDateTime createdAt, UserId userId) {
        Zoo zoo = Zoo.of(
            id,
            name,
            zooStatus,
            createdAt,
            LocalDateTime.now(),
            userId
        );
        zoos.save(zoo);
        return null;
    }
}
