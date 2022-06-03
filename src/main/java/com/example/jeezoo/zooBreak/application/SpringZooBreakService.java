package com.example.jeezoo.zooBreak.application;

import com.example.jeezoo.zooBreak.domain.ZooBreakRepository;
import com.example.jeezoo.zooBreak.domain.ZooBreakService;
import org.springframework.stereotype.Service;

@Service
public class SpringZooBreakService extends ZooBreakService {
    public SpringZooBreakService(ZooBreakRepository zooBreakRepository) {
        super(zooBreakRepository);
    }
}
