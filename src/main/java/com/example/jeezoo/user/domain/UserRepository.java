package com.example.jeezoo.user.domain;


import com.example.jeezoo.user.domain.model.User;
import com.example.jeezoo.user.domain.model.UserId;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

  UserId add(User user);

  User update(User user);

  List<User> findAll();

  User findById(UserId userId);

  Optional<User> findByUsername(String username);
}
