package com.example.jeezoo.zooBreak.infrastructure.jpa.h2;

import com.example.jeezoo.zooBreak.domain.ZooBreak;
import com.example.jeezoo.zooBreak.domain.ZooBreakId;
import com.example.jeezoo.zooBreak.domain.ZooBreakRepository;
import com.example.jeezoo.zooBreak.infrastructure.ZooBreakMapper;
import com.example.jeezoo.zooBreak.infrastructure.jpa.JpaZooBreakRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class H2ZooBreakRepository implements ZooBreakRepository {

    private final JpaZooBreakRepository jpaZooBreakRepository;
    private final ZooBreakMapper zooBreakMapper;

    public H2ZooBreakRepository(JpaZooBreakRepository jpaZooBreakRepository, ZooBreakMapper zooBreakMapper) {
        this.jpaZooBreakRepository = jpaZooBreakRepository;
        this.zooBreakMapper = zooBreakMapper;
    }

    @Override
    public List<ZooBreak> findAll() {
        return jpaZooBreakRepository.findAll()
                .stream()
                .map(zooBreakMapper::toModel)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<ZooBreak> findById(ZooBreakId id) {
        return jpaZooBreakRepository.findById(id.getValue())
                .map(zooBreakMapper::toModel);
    }

    @Override
    public ZooBreakId save(ZooBreak zooBreak) {
        return zooBreakMapper.toModel(jpaZooBreakRepository.save(zooBreakMapper.toEntity(zooBreak))).getId();
    }

    @Override
    public ZooBreakId delete(ZooBreakId id) {
        jpaZooBreakRepository.deleteById(id.getValue());
        return id;
    }
}
