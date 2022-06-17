package com.example.jeezoo.space.exposition.request;

import javax.validation.constraints.NotEmpty;

public final class CreateSpaceRequest {
    @NotEmpty
    public String name;
    public Long zooId;
}
