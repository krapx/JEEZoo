package com.example.jeezoo.zooBreak.domain;

import com.example.jeezoo.zooBreak.domain.exception.ZooBreakNotFoundException;

import java.util.List;

public class ZooBreakService {
    private final ZooBreakRepository zooBreakRepository;

    public ZooBreakService(ZooBreakRepository zooBreakRepository) {
        this.zooBreakRepository = zooBreakRepository;
    }

    public List<ZooBreak> getAll() {
        return zooBreakRepository.findAll();
    }

    public ZooBreak getById(ZooBreakId id) {
        return zooBreakRepository.findById(id).orElseThrow(() -> new ZooBreakNotFoundException(id));
    }

    public ZooBreakId save(ZooBreak zooBreak) {
        return zooBreakRepository.save(zooBreak);
    }

    public ZooBreakId remove(ZooBreakId id) {
        return zooBreakRepository.delete(id);
    }
}
