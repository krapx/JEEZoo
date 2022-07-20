package com.example.jeezoo.zoo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data(staticConstructor = "of")
public class ZooId {

    private final Long value;

    public static ZooId notCreatedYet(){
        return new ZooId(-1L);
    }
}
