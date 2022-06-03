package com.example.jeezoo.fight.infrastructure.jpa;

import com.example.jeezoo.fight.infrastructure.FightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFightRepository extends JpaRepository<FightEntity, Long> {
}
