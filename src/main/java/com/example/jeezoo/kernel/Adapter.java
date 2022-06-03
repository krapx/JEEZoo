package com.example.jeezoo.kernel;

public interface Adapter<S, D> {

  D adapt(S source);
}
