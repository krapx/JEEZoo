package com.example.jeezoo.space.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Data;
import lombok.NonNull;

@Data
public final class CreateSpaceCmd implements Command {
    @NonNull
    public String name;
}
