package com.example.jeezoo.space.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data(staticConstructor = "of")
public final class CreateSpaceCmd implements Command {
    @NotEmpty
    public final String name;
    @NotEmpty
    public final String status;
    @NotNull
    public final Long zooId;
    @NotEmpty
    public final int defeatedCount;

}
