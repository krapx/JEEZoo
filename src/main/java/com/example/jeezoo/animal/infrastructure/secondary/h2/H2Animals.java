package com.example.jeezoo.animal.infrastructure.secondary.h2;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.animal.infrastructure.secondary.AnimalAdapter;
import com.example.jeezoo.animal.infrastructure.secondary.AnimalMapper;
import com.example.jeezoo.animal.infrastructure.secondary.jpa.JpaAnimals;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository()
public class H2Animals implements Animals {

  private final Logger        logger = Logger.getLogger(H2Animals.class.getName());
  private final JpaAnimals    jpaAnimals;
  private final AnimalMapper  animalMapper;
  private final AnimalAdapter animalAdapter;

  public H2Animals(JpaAnimals jpaAnimals) {
    this.jpaAnimals = jpaAnimals;
    this.animalMapper = new AnimalMapper();
    this.animalAdapter = new AnimalAdapter();
  }

  @Override
  public void deleteById(AnimalId animalId) {
    logger.info(String.format("DELETE %s", animalId));
    jpaAnimals.deleteById(animalId.getValue());
  }

  @Override
  public AnimalId save(Animal animal) {
    logger.info(String.format("SAVE %s", animal));
    var animalSaved = jpaAnimals.save(animalAdapter.adapt(animal));
    return AnimalId.of(animalSaved.getId());
  }

  @Override
  public Optional<Animal> findById(AnimalId animalId) {
    logger.info(String.format("FIND BY ID %s", animalId));
    return jpaAnimals.findById(animalId.getValue()).map(animalMapper::adapt);
  }

  @Override
  public List<Animal> findAll() {
    logger.info("FIND ALL");
    return jpaAnimals.findAll().stream().map(animalMapper::adapt).collect(Collectors.toList());
  }
}
