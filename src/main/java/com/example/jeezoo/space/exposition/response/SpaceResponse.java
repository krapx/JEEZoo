package com.example.jeezoo.space.exposition.response;

import com.example.jeezoo.space.domain.Space;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
public final class SpaceResponse {

    private Long id;
    private String name;
    private String status;
    private Long zooId;

    public static SpaceResponse fromSpace(Space space) {
        return new SpaceResponse(
            space.getId().getValue(),
            space.getName(),
            space.getStatus().name(),
            space.getZooId().getValue()
        );
    }
}
