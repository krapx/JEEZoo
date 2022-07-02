package com.example.jeezoo.user.domain.model;


import lombok.Getter;

@Getter
public class User {

  private final String   username;
  private final String   password;
  private final UserRole userRole;
  private final String   mail;
  private       UserId   userId;

  private User(String username, String password, UserRole userRole, String mail, UserId userId) {
    this.username = username;
    this.password = password;
    this.userRole = userRole;
    this.mail = mail;
    this.userId = userId;
  }

  public static User of(String username, String password, UserRole userRole,
                        String mail, UserId userId) {
    return new User(username, password, userRole, mail, userId);
  }

  public void addUserId(UserId userId) {
    this.userId = userId;
  }
}
