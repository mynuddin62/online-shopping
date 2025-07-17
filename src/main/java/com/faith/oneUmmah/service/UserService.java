package com.faith.oneUmmah.service;

import com.faith.oneUmmah.dto.UserDTO;

public interface UserService {
    void saveUser(UserDTO userDTO);
    boolean isNotUniqueUsername(UserDTO user);
    boolean isNotUniqueEmail(UserDTO user);
}
