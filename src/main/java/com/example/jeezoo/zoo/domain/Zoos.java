package com.example.jeezoo.zoo.domain;

import com.example.jeezoo.player.domain.model.PlayerId;

import java.util.List;
import java.util.Optional;

public interface Zoos {
    ZooId save(Zoo zoo);
    Optional<Zoo> findById(ZooId zooId);
    List<Zoo> findAll();
    List<Zoo> findAllByPlayerId(PlayerId playerId);
    void deleteById(ZooId zooId);
}
