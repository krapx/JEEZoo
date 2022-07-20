package com.example.jeezoo.animal.infrastructure.primary.request;

import lombok.Data;

@Data(staticConstructor = "of")
public class UpdateAnimalRequest {

    private final String name;
    private final String type;
    private final String status;
    private final float lengthMax;
    private final float weightMax;
    private final String imageLink;
    private final Long spaceId;
}
