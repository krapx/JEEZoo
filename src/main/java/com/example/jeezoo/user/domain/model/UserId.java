package com.example.jeezoo.user.domain.model;

import com.example.jeezoo.kernel.ValueObjectId;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public final class UserId implements ValueObjectId {

  private final int value;

  public UserId(int value) {
    this.value = value;
  }

  public static UserId of(int value) {
    return new UserId(value);
  }


  @Override
  public Long getValue() {
    return null;
  }
}
