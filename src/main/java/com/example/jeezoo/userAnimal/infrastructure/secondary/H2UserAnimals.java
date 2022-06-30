package com.example.jeezoo.userAnimal.infrastructure.secondary;

import com.example.jeezoo.kernel.annotations.Repository;
import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.userAnimal.domain.UserAnimal;
import com.example.jeezoo.userAnimal.domain.UserAnimalId;
import com.example.jeezoo.userAnimal.domain.UserAnimals;

import java.util.Optional;
import java.util.logging.Logger;

import static java.lang.String.format;

@Repository
public class H2UserAnimals implements UserAnimals {

    private final Logger logger = Logger.getLogger(H2UserAnimals.class.getName());
    private final JpaUserAnimals jpaUserAnimals;
    private final UserAnimalMapper userAnimalMapper;

    public H2UserAnimals(JpaUserAnimals jpaUserAnimals, UserAnimalMapper userAnimalMapper) {
        this.jpaUserAnimals = jpaUserAnimals;
        this.userAnimalMapper = userAnimalMapper;
    }

    @Override
    public Optional<UserAnimal> findById(UserAnimalId userAnimalId) {
        logger.info(format("[H2UserAnimals] findById {}", userAnimalId.getValue()));
        return jpaUserAnimals.findById(userAnimalId.getValue()).map(userAnimalMapper::toModel);
    }

    @Override
    public Optional<UserAnimal> findByUserId(UserId userId) {
        logger.info(format("[H2UserAnimals] findByUserId {}", userId.getValue()));
        return jpaUserAnimals.findByUserId(userId.getValue()).map(userAnimalMapper::toModel);
    }

    @Override
    public UserAnimalId save(UserAnimal userAnimal) {
        logger.info(format("[H2UserAnimals] save {}", userAnimal.toString()));
        return userAnimalMapper.toModel(jpaUserAnimals.save(userAnimalMapper.toEntity(userAnimal))).getId();
    }
}
