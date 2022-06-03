package com.example.jeezoo.user.domain.model;


import lombok.Getter;

@Getter
public class DefaultUser implements User {

  private final String   lastname;
  private final String   firstname;
  private final String   login;
  private final String   password;
  private final UserRole userRole;
  private final String   mail;
  private       UserId   userId;
  private       Address  address;

  private DefaultUser(String lastname, String firstname, String login, String password, UserRole userRole, String mail,
                      UserId us, Address address) {
    this.lastname = lastname;
    this.firstname = firstname;
    this.login = login;
    this.password = password;
    this.userRole = userRole;
    this.mail = mail;
    this.userId = us;
    this.address = address;
  }

  public static DefaultUser of(String lastname, String firstname, String login, String password, UserRole userRole,
                               String mail, UserId userId, Address address) {
    return new DefaultUser(lastname, firstname, login, password, userRole, mail, userId, address);
  }


  @Override
  public UserRole getUserRole() {
    return null;
  }

  @Override
  public void changeAddress(Address address) {

  }
}
