package com.example.jeezoo.zooBreak.exposition.request;

import javax.validation.constraints.NotNull;

public final class UpdateZooBreakRequest {
    @NotNull
    public Long id;
    public String title;
}
