package com.example.jeezoo.zoo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
public class ZooId {

    private final Long value;

    public static ZooId notCreatedYet(){
        return new ZooId(-1L);
    }
}
