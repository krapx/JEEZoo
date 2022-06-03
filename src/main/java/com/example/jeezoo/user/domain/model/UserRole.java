package com.example.jeezoo.user.domain.model;

public enum UserRole {
  PLAYER("player"), ADMIN("admin");

  private final String role;

  UserRole(String role) {
    this.role = role;
  }

  public static UserRole fromString(String text) {
    for (UserRole val : UserRole.values()) {
      if (val.role.equalsIgnoreCase(text)) {
        return val;
      }
    }
    return null;
  }

  public String getValue() {
    return this.role;
  }


}
