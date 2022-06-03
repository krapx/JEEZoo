package com.example.jeezoo.zooBreak.domain;

import lombok.Data;

@Data(staticConstructor = "of")
public final class ZooBreak {

    private final ZooBreakId id;
    private final String title;

    public static ZooBreak createZooBreak(String title) {
        return new ZooBreak(new ZooBreakId(), title);
    }
}
