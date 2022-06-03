package com.example.jeezoo.user.domain;


import com.example.jeezoo.user.domain.model.User;
import com.example.jeezoo.user.domain.model.UserId;
import java.util.List;

public interface UserRepository {

  User add(User user);

  User update(User user);

  List<User> findAll();

  User findById(UserId userId);

  List<User> findByCity(String city);

  List<User> findByRole(String role);
}
