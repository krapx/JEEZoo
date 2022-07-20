package com.example.jeezoo.zoo.domain;

import com.example.jeezoo.kernel.annotations.AggregateRoot;
import com.example.jeezoo.user.domain.model.UserId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@AggregateRoot
@Getter
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class Zoo {

    private final ZooId id;
    private final String name;
    private final ZooStatus zooStatus;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final UserId userId;

    public static Zoo createZoo(String name, ZooStatus zooStatus, UserId userId) {
        return new Zoo(
            ZooId.notCreatedYet(),
            name,
            zooStatus,
            LocalDateTime.now(),
            LocalDateTime.now(),
            userId
        );
    }
}
