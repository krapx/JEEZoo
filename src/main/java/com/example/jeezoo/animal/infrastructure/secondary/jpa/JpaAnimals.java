package com.example.jeezoo.animal.infrastructure.secondary.jpa;

import com.example.jeezoo.animal.infrastructure.secondary.jpa.entity.AnimalEntity;
import com.example.jeezoo.space.domain.SpaceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaAnimals extends JpaRepository<AnimalEntity, Long> {
    List<AnimalEntity> findBySpaceId(Long spaceId);
    Long countBySpaceIdInAndStatus(List<Long> spaceIdList, String status);
}
