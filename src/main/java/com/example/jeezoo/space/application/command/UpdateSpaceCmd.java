package com.example.jeezoo.space.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Builder;
import lombok.NonNull;

@Builder
public final class UpdateSpaceCmd implements Command {
    @NonNull
    public Long id;
    public String name;
    public String status;
    public Long zooId;
}
