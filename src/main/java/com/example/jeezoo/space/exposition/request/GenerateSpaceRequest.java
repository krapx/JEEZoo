package com.example.jeezoo.space.exposition.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record GenerateSpaceRequest(
    @NotEmpty String name,
    @NotEmpty String status,
    @NotNull int animalsNumber
) {}
