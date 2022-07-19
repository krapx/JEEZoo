package com.example.jeezoo.space.exposition.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GenerateSpaceRequest {

    @NotEmpty
    public String name;
    @NotNull
    public int animalsNumber;

    @Override
    public String toString() {
        return "GenerateSpace{" +
            "name='" + name + '\'' +
            ", animalsNumber=" + animalsNumber +
            '}';
    }
}
