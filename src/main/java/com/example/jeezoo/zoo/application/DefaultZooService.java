package com.example.jeezoo.zoo.application;

import com.example.jeezoo.zoo.domain.*;

public class DefaultZooService implements ZooService {

    private final Zoos zoos;

    public DefaultZooService(Zoos zoos) {
        this.zoos = zoos;
    }

    @Override
    public ZooId addZoo(String name, String location, Float size, String spaceCapacity, String peopleCapacity, ZooStatus zooStatus) {
        Zoo zoo = Zoo.createZoo(name,location,size,spaceCapacity,peopleCapacity,zooStatus);
        return zoos.save(zoo);
    }
}
