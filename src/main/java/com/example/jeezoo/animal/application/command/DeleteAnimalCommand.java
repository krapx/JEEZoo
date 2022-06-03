package com.example.jeezoo.animal.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Data;
import lombok.NonNull;

@Data
public final class DeleteAnimalCommand implements Command {
    @NonNull
    public Long id;
}
