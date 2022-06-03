package com.example.jeezoo.zooBreak.infrastructure;

import com.example.jeezoo.zooBreak.domain.ZooBreak;
import com.example.jeezoo.zooBreak.domain.ZooBreakId;
import org.springframework.stereotype.Component;

@Component
public final class ZooBreakMapper {

    public ZooBreakEntity toEntity(ZooBreak zooBreak) {
        return new ZooBreakEntity().id(zooBreak.getId().getValue()).title(zooBreak.getTitle());
    }

    public ZooBreak toModel(ZooBreakEntity zooBreakEntity) {
        return ZooBreak.of(new ZooBreakId(zooBreakEntity.getId()), zooBreakEntity.getTitle());
    }
}
