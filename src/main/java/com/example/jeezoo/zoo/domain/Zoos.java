package com.example.jeezoo.zoo.domain;

import java.util.List;
import java.util.Optional;

public interface Zoos {

    ZooId save(Zoo zoo);

    Optional<Zoo> findById(ZooId zooId);

    List<Zoo> findAll();

    void deleteById(ZooId zooId);
}
