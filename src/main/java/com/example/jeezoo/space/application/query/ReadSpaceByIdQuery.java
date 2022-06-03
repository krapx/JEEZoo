package com.example.jeezoo.space.application.query;

import com.example.jeezoo.kernel.cqs.Query;
import lombok.Data;
import lombok.NonNull;

@Data
public final class ReadSpaceByIdQuery implements Query {
    @NonNull
    private Long id;
}
