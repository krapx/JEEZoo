package com.example.jeezoo.fight.exposition.request;

import javax.validation.constraints.NotNull;

public final class UpdateFightRequest {
    @NotNull
    public Long id;
    public String title;
}
