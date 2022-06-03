package com.example.jeezoo.zoo.infrastructure.primary.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ZooResponse {

    public Long id;
    public String name;
    public String location;
    public Float size;
    public String spaceCapacity;
    public String peopleCapacity;
    public String zooStatus;
}
