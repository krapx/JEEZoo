package com.example.jeezoo.userAnimal.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserAnimals extends JpaRepository<UserAnimalEntity, Long> {
    Optional<UserAnimalEntity> findByUserId(Long userId);
}
