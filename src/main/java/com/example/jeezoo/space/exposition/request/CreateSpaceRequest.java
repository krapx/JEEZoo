package com.example.jeezoo.space.exposition.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public final class CreateSpaceRequest {
    @NotEmpty
    public String name;
    @NotEmpty
    public String status;
    @NotNull
    public Long zooId;
}
