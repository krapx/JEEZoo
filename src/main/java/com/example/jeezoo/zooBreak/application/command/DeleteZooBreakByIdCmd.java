package com.example.jeezoo.zooBreak.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Data;
import lombok.NonNull;

@Data
public final class DeleteZooBreakByIdCmd implements Command {
    @NonNull
    private Long id;
}
