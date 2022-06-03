package com.example.jeezoo.zooBreak.exposition.request;

import javax.validation.constraints.NotEmpty;

public final class CreateZooBreakRequest {
    @NotEmpty
    public String title;
}
