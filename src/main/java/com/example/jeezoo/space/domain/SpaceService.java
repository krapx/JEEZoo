package com.example.jeezoo.space.domain;

import com.example.jeezoo.space.domain.exception.SpaceNotFoundException;
import com.example.jeezoo.zoo.domain.ZooService;

import java.util.List;

public class SpaceService {
    private final SpaceRepository spaceRepository;

    private final ZooService zooService;

    public SpaceService(SpaceRepository spaceRepository, ZooService zooService) {
        this.spaceRepository = spaceRepository;
        this.zooService = zooService;
    }

    public List<Space> getAll() {
        return spaceRepository.findAll();
    }

    public Space getById(SpaceId id) {
        return spaceRepository.findById(id).orElseThrow(() -> new SpaceNotFoundException(id));
    }

    public SpaceId save(Space space) {
        zooService.getZooById(space.getZooId());
        return spaceRepository.save(space);
    }

    public SpaceId remove(SpaceId id) {
        return spaceRepository.delete(id);
    }
}
