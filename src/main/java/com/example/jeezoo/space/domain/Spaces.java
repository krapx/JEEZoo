package com.example.jeezoo.space.domain;

import com.example.jeezoo.zoo.domain.ZooId;

import java.util.List;
import java.util.Optional;

public interface Spaces {
    List<Space> findAll();
    List<Space> findAllByZooId(ZooId zooId);
    Optional<Space> findById(SpaceId id);
    Optional<Space> findFirstByZooIdAndStatus(ZooId zooId, SpaceStatus status);
    SpaceId save(Space Space);
    SpaceId delete(SpaceId id);
    Long countByZooIdAndStatus(ZooId zooId, SpaceStatus status);
    Long countByZooId(ZooId zooId);
    boolean existsByZooIdAndStatus(ZooId zooId, SpaceStatus status);
}
