package com.example.jeezoo.animal.infrastructure.secondary.jpa;

import com.example.jeezoo.animal.infrastructure.secondary.jpa.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAnimals extends JpaRepository<AnimalEntity, Long> {

}
