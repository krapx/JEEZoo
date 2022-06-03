package com.example.jeezoo.kernel.event;

public interface EventDispatcher<E extends Event> {

  void dispatch(E event);
}
