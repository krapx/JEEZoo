package com.example.jeezoo.zoo.domain;

import com.example.jeezoo.user.domain.model.UserId;

import java.util.List;
import java.util.Optional;

public interface Zoos {
    ZooId save(Zoo zoo);
    Optional<Zoo> findById(ZooId zooId);
    List<Zoo> findAll();
    List<Zoo> findAllByUserId(UserId userId);
    void deleteById(ZooId zooId);
}
