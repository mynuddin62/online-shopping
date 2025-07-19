package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class UserRepositoryImpl implements UserRepository {

    private static final Set<User> USERS = new CopyOnWriteArraySet<>();

    static {
        try {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("mynuddin.dev@gmail.com");
            admin.setFirstName("Mynuddin");
            admin.setLastName("Helal");
            USERS.add(admin);
            admin.setPassword(Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256").digest("1245".getBytes(StandardCharsets.UTF_8))));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


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
