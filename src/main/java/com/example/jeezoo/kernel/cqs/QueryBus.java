package com.example.jeezoo.kernel.cqs;

public interface QueryBus {

  <Q extends Query, R> R send(Q query);
}