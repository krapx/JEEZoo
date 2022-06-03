package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Data;
import lombok.NonNull;

@Data
public final class DeleteZooCommand implements Command {
    @NonNull
    public Long id;
}
