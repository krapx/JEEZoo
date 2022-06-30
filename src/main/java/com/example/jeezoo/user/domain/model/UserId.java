package com.example.jeezoo.user.domain.model;

import com.example.jeezoo.kernel.ValueObjectId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data(staticConstructor = "of")
public final class UserId {

  private final Long value;

  public static UserId create() {
    return new UserId(-1L);
  }
}
