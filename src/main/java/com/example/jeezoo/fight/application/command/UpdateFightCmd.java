package com.example.jeezoo.fight.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Builder;
import lombok.NonNull;

@Builder
public final class UpdateFightCmd implements Command {
    @NonNull
    public Long id;
    public String title;
}
