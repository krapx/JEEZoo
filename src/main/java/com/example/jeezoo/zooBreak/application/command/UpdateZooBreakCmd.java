package com.example.jeezoo.zooBreak.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Builder;
import lombok.NonNull;

@Builder
public final class UpdateZooBreakCmd implements Command {
    @NonNull
    public Long id;
    public String title;
}
