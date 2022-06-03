package com.example.jeezoo.space.domain;

import java.util.List;
import java.util.Optional;

public interface SpaceRepository {
    List<Space> findAll();
    Optional<Space> findById(SpaceId id);
    SpaceId save(Space Space);
    SpaceId delete(SpaceId id);
}
