package com.example.jeezoo.kernel.cqs;

public interface QueryHandler<Q extends Query, R> {

  R handle(Q query);
}
