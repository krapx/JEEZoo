package com.example.jeezoo.fight.infrastructure.jpa.h2;

import com.example.jeezoo.fight.domain.Fight;
import com.example.jeezoo.fight.domain.FightId;
import com.example.jeezoo.fight.domain.FightRepository;
import com.example.jeezoo.fight.infrastructure.FightMapper;
import com.example.jeezoo.fight.infrastructure.jpa.JpaFightRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class H2FightRepository implements FightRepository {

    private final JpaFightRepository jpaFightRepository;
    private final FightMapper fightMapper;

    public H2FightRepository(JpaFightRepository jpaFightRepository, FightMapper fightMapper) {
        this.jpaFightRepository = jpaFightRepository;
        this.fightMapper = fightMapper;
    }

    @Override
    public List<Fight> findAll() {
        return jpaFightRepository.findAll()
                .stream()
                .map(fightMapper::toModel)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<Fight> findById(FightId id) {
        return jpaFightRepository.findById(id.getValue())
                .map(fightMapper::toModel);
    }

    @Override
    public FightId save(Fight fight) {
        return fightMapper.toModel(jpaFightRepository.save(fightMapper.toEntity(fight))).getId();
    }

    @Override
    public FightId delete(FightId id) {
        jpaFightRepository.deleteById(id.getValue());
        return id;
    }
}
