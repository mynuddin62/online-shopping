package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.User;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class UserRepositoryImpl implements UserRepository {

    private static final Set<User> USERS = new CopyOnWriteArraySet<>();

    @Override
    public void save(User user) {
        USERS.add(user);
        System.out.println(USERS);
    }
}
