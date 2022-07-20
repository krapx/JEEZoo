package com.example.jeezoo.space.application;

import com.example.jeezoo.space.domain.Spaces;
import com.example.jeezoo.space.domain.SpaceService;
import com.example.jeezoo.zoo.domain.ZooService;
import org.springframework.stereotype.Service;

@Service
public class SpringSpaceService extends SpaceService {

    public SpringSpaceService(Spaces spaces, ZooService zooService) {
        super(spaces, zooService);
    }
}
