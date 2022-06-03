package com.example.jeezoo.kernel.event;

public interface EventListener<E extends Event> {

  void listenTo(E event);
}
