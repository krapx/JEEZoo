package com.example.jeezoo.player.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPlayer extends JpaRepository<PlayerEntity, Long> {
}
