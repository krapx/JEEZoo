package com.example.jeezoo.user.infrastructure.secondary;

import com.example.jeezoo.userAnimal.infrastructure.secondary.UserAnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUser extends JpaRepository<UserEntity, Long> {
}
