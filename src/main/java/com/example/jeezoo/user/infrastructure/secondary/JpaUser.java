package com.example.jeezoo.user.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUser extends JpaRepository<UserEntity, Long> {
}
