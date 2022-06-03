package com.example.jeezoo.fight.exposition.request;

import javax.validation.constraints.NotEmpty;

public final class CreateFightRequest {
    @NotEmpty
    public String title;
}
