package com.example.jeezoo.zoo.infrastructure.primary.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ZooResponse {

    public Long id;
    public String name;
    public String zooStatus;
}
