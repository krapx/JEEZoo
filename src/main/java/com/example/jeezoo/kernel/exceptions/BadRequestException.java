package com.example.jeezoo.kernel.exceptions;


public final class BadRequestException extends RuntimeException {

  public BadRequestException(String message) {
    super(message);
  }

}
