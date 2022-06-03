package com.example.jeezoo.animal.domain;

import com.example.jeezoo.kernel.ValueObjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class AnimalId implements ValueObjectId {

  private final Long value;

  public static AnimalId of(Long id) {
    return new AnimalId(id);
  }

  public static AnimalId noId() {
    return new AnimalId(-1L);
  }
}
