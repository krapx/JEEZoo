package com.example.jeezoo.space.domain;

import com.example.jeezoo.space.domain.exception.SpaceMaxException;
import com.example.jeezoo.space.domain.exception.SpaceNotFoundException;
import com.example.jeezoo.zoo.domain.ZooId;
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

    public Space getNextByZooIdAndStatus(ZooId zooId, SpaceStatus status) {
        return spaces
            .findFirstByZooIdAndStatus(zooId, status)
            .orElseThrow(() -> new SpaceNotFoundException(zooId, status));
    }

    public SpaceId create(Space space) {
        Long numberOfSpaceInZoo = spaces.countByZooId(space.getZooId());
        if (numberOfSpaceInZoo >= 6) throw new SpaceMaxException(space.getZooId());
        return spaces.save(space);
    }

    public SpaceId save(Space space) {
        zooService.getZooById(space.getZooId());
        return spaces.save(space);
    }

    public void saveStatus(SpaceId spaceId, SpaceStatus status) {
        Space space = getById(spaceId);
        Space newSpace = Space.of(
            space.getId(),
            space.getName(),
            status,
            space.getZooId(),
            space.getDefeatedCount()
        );
        spaces.save(newSpace);
    }

    public SpaceId remove(SpaceId id) {
        return spaces.delete(id);
    }
}
