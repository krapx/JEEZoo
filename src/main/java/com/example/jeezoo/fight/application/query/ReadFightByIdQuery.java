package com.example.jeezoo.fight.application.query;

import com.example.jeezoo.kernel.cqs.Query;
import lombok.Data;
import lombok.NonNull;

@Data
public final class ReadFightByIdQuery implements Query {
    @NonNull
    private Long id;
}
