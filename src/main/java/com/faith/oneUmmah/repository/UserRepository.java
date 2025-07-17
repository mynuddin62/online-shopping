package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findByUserName(String username);
    Optional<User> findByEmail(String username);
}
