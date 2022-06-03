package com.example.jeezoo.animal.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class AddAnimalCommand implements Command {

  private final String    name;
  private final String    type;
  private final String    status;
  private final LocalDate arrivalDate;
  private final Long      spaceId;

}
