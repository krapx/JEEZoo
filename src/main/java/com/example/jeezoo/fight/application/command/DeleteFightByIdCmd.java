package com.example.jeezoo.fight.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Data;
import lombok.NonNull;

@Data
public final class DeleteFightByIdCmd implements Command {
    @NonNull
    private Long id;
}
