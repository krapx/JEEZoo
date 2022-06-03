package com.example.jeezoo.zooBreak.application.query;

import com.example.jeezoo.kernel.cqs.Query;
import lombok.Data;
import lombok.NonNull;

@Data
public final class ReadZooBreakByIdQuery implements Query {
    @NonNull
    private Long id;
}
