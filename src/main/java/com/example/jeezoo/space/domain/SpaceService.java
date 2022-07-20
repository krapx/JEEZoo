package com.example.jeezoo.space.domain;

import com.example.jeezoo.space.domain.exception.SpaceNotFoundException;
import com.example.jeezoo.zoo.domain.ZooService;

import java.util.List;

public class SpaceService {
    private final Spaces spaces;

    private final ZooService zooService;

    public SpaceService(Spaces spaces, ZooService zooService) {
        this.spaces = spaces;
        this.zooService = zooService;
    }

    public List<Space> getAll() {
        return spaces.findAll();
    }

    public Space getById(SpaceId id) {
        return spaces.findById(id).orElseThrow(() -> new SpaceNotFoundException(id));
    }

    public SpaceId save(Space space) {
        zooService.getZooById(space.getZooId());
        return spaces.save(space);
    }

    public SpaceId remove(SpaceId id) {
        return spaces.delete(id);
    }
}
