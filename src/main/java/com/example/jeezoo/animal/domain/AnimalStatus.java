package com.example.jeezoo.animal.domain;

import com.example.jeezoo.kernel.annotations.ValueObject;

@ValueObject
public enum AnimalStatus {
  Escaped, Free, InCage
}
