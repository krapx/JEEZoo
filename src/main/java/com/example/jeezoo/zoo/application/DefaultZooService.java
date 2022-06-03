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

    @Override
    public Void deleteZoo(Long id) {
        ZooId zooId = ZooId.of(id);
        zoos.deleteById(zooId);
        return null;
    }

    @Override
    public Void update(Long id, String name, String location, Float size, String spaceCapacity, String peopleCapacity,
                       String zooStatus) {
        Zoo zoo = Zoo.of(ZooId.of(id),name,location,size,spaceCapacity,peopleCapacity,ZooStatus.valueOf(zooStatus));
        zoos.save(zoo);
        return null;
    }
}
