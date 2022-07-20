package com.example.jeezoo.user.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUser extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
