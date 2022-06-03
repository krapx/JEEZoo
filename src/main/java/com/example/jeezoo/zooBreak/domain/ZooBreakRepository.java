package com.example.jeezoo.zooBreak.domain;

import java.util.List;
import java.util.Optional;

public interface ZooBreakRepository {
    List<ZooBreak> findAll();
    Optional<ZooBreak> findById(ZooBreakId id);
    ZooBreakId save(ZooBreak ZooBreak);
    ZooBreakId delete(ZooBreakId id);
}
