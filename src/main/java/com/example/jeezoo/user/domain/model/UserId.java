package com.example.jeezoo.user.domain.model;

import lombok.Data;

@Data(staticConstructor = "of")
public final class UserId {

  private final Long value;

  public static UserId notCreatedYet() {
    return new UserId(-1L);
  }
}