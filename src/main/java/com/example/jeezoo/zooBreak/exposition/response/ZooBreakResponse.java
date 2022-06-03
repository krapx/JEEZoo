package com.example.jeezoo.zooBreak.exposition.response;

import com.example.jeezoo.zooBreak.domain.ZooBreak;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
public final class ZooBreakResponse {
    private Long id;
    private String title;

    public static ZooBreakResponse fromZooBreak(ZooBreak zooBreak) {
        return new ZooBreakResponse(zooBreak.getId().getValue(), zooBreak.getTitle());
    }
}
