package com.example.jeezoo.space.exposition.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record CreateSpaceRequest(
    @NotEmpty
    String name,
    @NotEmpty
    String status,
    @NotNull
    Long zooId
) {
}
