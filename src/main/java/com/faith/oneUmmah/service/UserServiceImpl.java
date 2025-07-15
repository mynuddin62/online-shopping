package com.faith.oneUmmah.service;
import com.faith.oneUmmah.dto.UserDTO;
import com.faith.oneUmmah.domain.User;
import com.faith.oneUmmah.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

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

    private String encryptPassword(String password){
        // we will implement password encryption later
        return password;
    }
}
