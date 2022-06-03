package com.example.jeezoo.kernel.cqs;

public interface CommandHandler<C extends Command, R> {

  R handle(C command);
}
