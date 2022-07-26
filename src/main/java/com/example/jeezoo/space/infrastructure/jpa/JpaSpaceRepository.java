package com.example.jeezoo.space.infrastructure.jpa;

import com.example.jeezoo.space.infrastructure.SpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaSpaceRepository extends JpaRepository<SpaceEntity, Long> {

    List<SpaceEntity> findAllByZooId(Long zooId);
    Long countByZooIdAndStatus(Long zooId, String status);
    Long countByZooId(Long zooId);
    Optional<SpaceEntity> findFirstByZooIdAndStatus(Long zooId, String status);
    boolean existsByZooIdAndStatus(Long zooId, String status);
}
