package com.example.jeezoo.playerAnimal.infrastructure.secondary;

import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.playerAnimal.domain.PlayerAnimal;
import com.example.jeezoo.playerAnimal.domain.PlayerAnimalId;
import com.example.jeezoo.playerAnimal.domain.PlayerAnimals;
import com.example.jeezoo.zoo.domain.ZooId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static java.lang.String.format;

@Repository
public class H2PlayerAnimals implements PlayerAnimals {

    private final Logger logger = Logger.getLogger(H2PlayerAnimals.class.getName());
    private final JpaPlayerAnimals jpaPlayerAnimals;
    private final PlayerAnimalMapper playerAnimalMapper;

    public H2PlayerAnimals(JpaPlayerAnimals jpaPlayerAnimals, PlayerAnimalMapper playerAnimalMapper) {
        this.jpaPlayerAnimals = jpaPlayerAnimals;
        this.playerAnimalMapper = playerAnimalMapper;
    }

    @Override
    public List<PlayerAnimal> findAll() {
        return jpaPlayerAnimals.findAll().stream().map(playerAnimalMapper::toModel).toList();
    }

    @Override
    public Optional<PlayerAnimal> findById(PlayerAnimalId playerAnimalId) {
        logger.info(format("[H2PlayerAnimals] findById %d", playerAnimalId.getValue()));
        return jpaPlayerAnimals.findById(playerAnimalId.getValue()).map(playerAnimalMapper::toModel);
    }

    @Override
    public Optional<PlayerAnimal> findByPlayerId(PlayerId playerId) {
        logger.info(format("[H2PlayerAnimals] findByPlayerId %d", playerId.getValue()));
        return jpaPlayerAnimals.findByPlayerId(playerId.getValue()).map(playerAnimalMapper::toModel);
    }

    @Override
    public List<PlayerAnimal> findAllByZooId(ZooId zooId) {
        logger.info(format("[H2PlayerAnimals] findAllByZooId %d", zooId.getValue()));
        return jpaPlayerAnimals.findAllByZooId(zooId.getValue()).stream().map(playerAnimalMapper::toModel).toList();
    }

    @Override
    public PlayerAnimalId save(PlayerAnimal playerAnimal) {
        logger.info(format("[H2PlayerAnimals] save %s}", playerAnimal.toString()));
        return playerAnimalMapper.toModel(jpaPlayerAnimals.save(playerAnimalMapper.toEntity(playerAnimal))).getId();
    }
}
