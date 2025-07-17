package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.User;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class UserRepositoryImpl implements UserRepository {

    private static final Set<User> USERS = new CopyOnWriteArraySet<>();

    @Override
    public void save(User user) {
        USERS.add(user);
        System.out.println(USERS);
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return USERS.stream().filter(user -> Objects.equals(user.getUsername(), username)).findFirst();
    }

    @Override
    public Optional<User> findByEmail(String username) {
        return USERS.stream().filter(user -> Objects.equals(user.getEmail(), username)).findFirst();
    }
}
