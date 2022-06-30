package com.example.jeezoo.userAnimal.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserAnimals extends JpaRepository<UserAnimalEntity, Long> {
    Optional<UserAnimalEntity> findByUserId(Long userId);
}
