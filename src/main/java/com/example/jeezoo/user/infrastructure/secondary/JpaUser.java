package com.example.jeezoo.user.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUser extends JpaRepository<UserEntity, Long> {
}
