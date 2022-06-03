package com.example.jeezoo.zooBreak.infrastructure.jpa;

import com.example.jeezoo.zooBreak.infrastructure.ZooBreakEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaZooBreakRepository extends JpaRepository<ZooBreakEntity, Long> {
}
