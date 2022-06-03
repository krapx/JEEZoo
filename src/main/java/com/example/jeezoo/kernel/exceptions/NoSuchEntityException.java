package com.example.jeezoo.kernel.exceptions;


import com.example.jeezoo.kernel.ValueObjectId;

public final class NoSuchEntityException extends RuntimeException {

  public NoSuchEntityException(String message) {
    super(message);
  }

  public static <VOID extends ValueObjectId> NoSuchEntityException withId(VOID id) {
    return new NoSuchEntityException(String.format("No entity found with ID %s.", id.getValue()));
  }
}
