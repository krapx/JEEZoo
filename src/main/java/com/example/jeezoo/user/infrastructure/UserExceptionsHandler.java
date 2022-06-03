package com.example.jeezoo.user.infrastructure;

import com.example.jeezoo.user.infrastructure.primary.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice(basePackageClasses = UserController.class)
public class UserExceptionsHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public String handleIllegalArgumentException(IllegalArgumentException exception) {
    return exception.getMessage();
  }

//  @ExceptionHandler(UserNotFoundException.class)
//  @ResponseStatus(HttpStatus.NOT_FOUND)
//  @ResponseBody
//  public Map<String, Object> handleUserNotFoundException(ReportCardDataNotFoundException exception) {
//    HashMap<String, Object> result = new HashMap<>();
//    result.put("error", true);
//    result.put("error_message", exception.getMessage());
//    return result;
//  }
//
//  @ExceptionHandler(ReportCardDataConflictException.class)
//  @ResponseStatus(HttpStatus.CONFLICT)
//  @ResponseBody
//  public Map<String, Integer> handleUserConflictException(ReportCardDataConflictException exception) {
//    return Map.of(exception.getMessage(), exception.getStudentId());
//  }

}

