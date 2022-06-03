package com.example.jeezoo.space.domain;

import com.example.jeezoo.space.domain.exception.SpaceNotFoundException;

import java.util.List;

public class SpaceService {
    private final SpaceRepository spaceRepository;

    public SpaceService(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    public List<Space> getAll() {
        return spaceRepository.findAll();
    }

    public Space getById(SpaceId id) {
        return spaceRepository.findById(id).orElseThrow(() -> new SpaceNotFoundException(id));
    }

    public SpaceId save(Space space) {
        return spaceRepository.save(space);
    }

    public SpaceId remove(SpaceId id) {
        return spaceRepository.delete(id);
    }
}
