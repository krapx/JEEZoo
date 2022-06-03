package com.example.jeezoo.user.domain.model;


public interface User {

  String getLastname();

  String getFirstname();

  String getLogin();

  UserId getUserId();

  Address getAddress();

  UserRole getUserRole();

  String getMail();

  void changeAddress(Address address);

}
