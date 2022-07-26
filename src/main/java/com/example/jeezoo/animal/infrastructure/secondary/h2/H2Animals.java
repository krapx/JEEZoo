package com.example.jeezoo.animal.infrastructure.secondary.h2;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.domain.AnimalStatus;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.animal.infrastructure.secondary.AnimalAdapter;
import com.example.jeezoo.animal.infrastructure.secondary.AnimalMapper;
import com.example.jeezoo.animal.infrastructure.secondary.jpa.JpaAnimals;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.example.jeezoo.space.domain.SpaceId;
import org.springframework.stereotype.Repository;

import static java.lang.String.format;

@Repository
public class H2Animals implements Animals {

    private final Logger logger = Logger.getLogger(H2Animals.class.getName());
    private final JpaAnimals jpaAnimals;
    private final AnimalMapper animalMapper;
    private final AnimalAdapter animalAdapter;

    public H2Animals(JpaAnimals jpaAnimals) {
        this.jpaAnimals = jpaAnimals;
        this.animalMapper = new AnimalMapper();
        this.animalAdapter = new AnimalAdapter();
    }

    @Override
    public void deleteById(AnimalId animalId) {
        logger.info(format("DELETE %s", animalId));
        jpaAnimals.deleteById(animalId.getValue());
    }

    @Override
    public AnimalId save(Animal animal) {
        logger.info(format("SAVE %s", animal));
        var animalSaved = jpaAnimals.save(animalAdapter.adapt(animal));
        return AnimalId.of(animalSaved.getId());
    }

    @Override
    public Optional<Animal> findById(AnimalId animalId) {
        logger.info(format("FIND BY ID %s", animalId));
        return jpaAnimals.findById(animalId.getValue()).map(animalMapper::adapt);
    }

    @Override
    public List<Animal> findAll() {
        logger.info("FIND ALL");
        return jpaAnimals.findAll().stream().map(animalMapper::adapt).collect(Collectors.toList());
    }

    @Override
    public List<Animal> findAllBySpaceIdInAndStatus(List<SpaceId> spaceIdList, AnimalStatus status) {
        logger.info(format(
            "[ANIMALS] findAllBySpaceIdInAndStatus {spaceIdList: %s, status: %s}",
            spaceIdList.toString(),
            status.name()
        ));
        return jpaAnimals.findAllBySpaceIdInAndStatus(
            spaceIdList.stream().map(SpaceId::getValue).toList(),
            status.name()
        ).stream().map(animalMapper::adapt).collect(Collectors.toList());
    }

    @Override
    public List<Animal> findBySpaceId(SpaceId spaceId) {
        logger.info("FIND ALL BY SPACE ID");
        return jpaAnimals.findBySpaceId(spaceId.getValue())
            .stream()
            .map(animalMapper::adapt)
            .collect(Collectors.toList());
    }

    @Override
    public Long countBySpaceIdInAndStatus(List<SpaceId> spaceIdList, AnimalStatus status) {
        return jpaAnimals.countBySpaceIdInAndStatus(
            spaceIdList.stream().map(SpaceId::getValue).toList(),
            status.name()
        );
    }

    @Override
    public boolean existsBySpaceIdAndStatus(SpaceId spaceId, AnimalStatus status) {
        return jpaAnimals.existsBySpaceIdAndStatus(spaceId.getValue(), status.name());
    }
}
