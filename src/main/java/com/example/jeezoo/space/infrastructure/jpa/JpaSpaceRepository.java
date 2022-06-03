package com.example.jeezoo.space.infrastructure.jpa;

import com.example.jeezoo.space.infrastructure.SpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSpaceRepository extends JpaRepository<SpaceEntity, Long> {
}
