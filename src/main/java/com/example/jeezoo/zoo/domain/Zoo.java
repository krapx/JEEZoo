package com.example.jeezoo.zoo.domain;

import com.example.jeezoo.kernel.annotations.AggregateRoot;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AggregateRoot
@Getter
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class Zoo {

    private final ZooId id;
    private final String name;
    private final String location;
    private final Float size;
    private final String spaceCapacity;
    private final String peopleCapacity;
    private final ZooStatus zooStatus;

    public static Zoo createZoo(String name, String location, Float size, String spaceCapacity,
                         String peopleCapacity, ZooStatus zooStatus) {
        return new Zoo(ZooId.noId(),name,location,size,spaceCapacity,peopleCapacity,zooStatus);
    }
}
