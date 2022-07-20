package com.example.jeezoo.user.infrastructure.secondary;

import com.example.jeezoo.user.domain.UserRepository;
import com.example.jeezoo.user.domain.model.User;
import com.example.jeezoo.user.domain.model.UserId;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static java.lang.String.format;

@Repository
public class H2User implements UserRepository {

    private final Logger logger = Logger.getLogger(H2User.class.getName());
    private final JpaUser jpaUser;
    private final UserAdapter userAdapter;

    public H2User(JpaUser jpaUser, UserAdapter userAdapter) {
        this.jpaUser = jpaUser;
        this.userAdapter = userAdapter;
    }

    @Override
    public UserId add(User user) {
        var userEntity = jpaUser.save(userAdapter.toEntity(user));
        var userSaved = userAdapter.toModel(userEntity);
        return userSaved.getId();
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return jpaUser.findAll().stream().map(userAdapter::toModel).toList();
    }

    @Override
    public User findById(UserId userId) {
        Optional<User> user = jpaUser.findById(userId.getValue()).map(userAdapter::toModel);
        if (user.isPresent())
            return user.get();
        else
            throw new NoResultException("User not found, id = " + userId.getValue());
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<User> user = jpaUser.findByUsername(username).map(userAdapter::toModel);
        if (user.isPresent())
            return user;
        else
            throw new NoResultException("User not found, username = " + user);
    }
}
