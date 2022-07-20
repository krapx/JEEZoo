package com.example.jeezoo.player.domain.model;

import lombok.Data;

@Data(staticConstructor = "of")
public final class PlayerId {

  private final Long value;

  public static PlayerId notCreatedYet() {
    return new PlayerId(-1L);
  }
}