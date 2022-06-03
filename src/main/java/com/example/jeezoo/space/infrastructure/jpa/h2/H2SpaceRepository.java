package com.example.jeezoo.space.infrastructure.jpa.h2;

import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.space.domain.SpaceRepository;
import com.example.jeezoo.space.infrastructure.SpaceMapper;
import com.example.jeezoo.space.infrastructure.jpa.JpaSpaceRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class H2SpaceRepository implements SpaceRepository {

    private final JpaSpaceRepository jpaSpaceRepository;
    private final SpaceMapper spaceMapper;

    public H2SpaceRepository(JpaSpaceRepository jpaSpaceRepository, SpaceMapper spaceMapper) {
        this.jpaSpaceRepository = jpaSpaceRepository;
        this.spaceMapper = spaceMapper;
    }

    @Override
    public List<Space> findAll() {
        return jpaSpaceRepository.findAll()
            .stream()
            .map(spaceMapper::toModel)
            .toList();
    }

    @Override
    public Optional<Space> findById(SpaceId id) {
        return jpaSpaceRepository.findById(id.getValue())
                .map(spaceMapper::toModel);
    }

    @Override
    public SpaceId save(Space space) {
        return spaceMapper.toModel(jpaSpaceRepository.save(spaceMapper.toEntity(space))).getId();
    }

    @Override
    public SpaceId delete(SpaceId id) {
        jpaSpaceRepository.deleteById(id.getValue());
        return id;
    }
}
