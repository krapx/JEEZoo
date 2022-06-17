package com.example.jeezoo.space.exposition.request;

import javax.validation.constraints.NotNull;

public final class UpdateSpaceRequest {
    @NotNull
    public Long id;
    public String name;
}
