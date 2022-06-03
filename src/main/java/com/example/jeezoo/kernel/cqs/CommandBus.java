package com.example.jeezoo.kernel.cqs;

public interface CommandBus {

  <C extends Command, R> R send(C command);
}