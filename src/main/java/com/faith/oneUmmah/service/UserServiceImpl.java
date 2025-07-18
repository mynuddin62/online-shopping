package com.faith.oneUmmah.service;
import com.faith.oneUmmah.dto.LoginDTO;
import com.faith.oneUmmah.dto.UserDTO;
import com.faith.oneUmmah.domain.User;
import com.faith.oneUmmah.exception.UserNotFoundException;
import com.faith.oneUmmah.repository.UserRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        String encryptedPass = encryptPassword(userDTO.getPassword());
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(encryptedPass);

        userRepository.save(user);
    }

    @Override
    public boolean isNotUniqueUsername(UserDTO user) {
        return userRepository.findByUserName(user.getUsername()).isPresent();
    }

    @Override
    public boolean isNotUniqueEmail(UserDTO user) {
        return userRepository.findByEmail(user.getEmail()).isPresent();
    }

    @Override
    public User verifyUser(LoginDTO loginDTO) {
        var user = userRepository.findByUserName(loginDTO.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Username or Password is incorrect"));

        var encryptedPassword = encryptPassword(loginDTO.getPassword());

        if(user.getPassword().equals(encryptedPassword)) {
            return user;
        }else {
            throw new UserNotFoundException("Username or Password is incorrect");
        }
    }

    private String encryptPassword(String password){
        try {
            var digester = MessageDigest.getInstance("SHA-256");
            var bytes = digester.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to encrypt password", e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
