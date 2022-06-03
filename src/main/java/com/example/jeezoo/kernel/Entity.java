package com.example.jeezoo.kernel;

@SuppressWarnings("all")
public interface Entity<VOID extends ValueObjectId> {

  VOID id();
}
