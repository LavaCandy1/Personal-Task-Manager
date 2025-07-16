package com.LavaCandy.Personal.Task.Manager.service;

import com.LavaCandy.Personal.Task.Manager.model.User;
import com.LavaCandy.Personal.Task.Manager.repository.UserRepository;
import com.LavaCandy.Personal.Task.Manager.dto.UserRequestDTO;
import com.LavaCandy.Personal.Task.Manager.dto.UserResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    // public User creatUser(User user) {
    //     return userRepository.save(user);
    // }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        User savedUser = userRepository.save(user);
              
        return new UserResponseDTO(savedUser);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserResponseDTO::new).toList();
    }

    public UserResponseDTO getUserById(Long id) {
        User foundUser =  userRepository.findById(id).orElse(null);
        if (foundUser != null) {
            return new UserResponseDTO(foundUser);
        } else return null;
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(userRequestDTO.getName());
            updatedUser.setEmail(userRequestDTO.getEmail());
            updatedUser.setPassword(userRequestDTO.getPassword());
            // Save the updated user
            User updatedUser2 =  userRepository.save(updatedUser);
            return new UserResponseDTO(updatedUser2);
        }
        return null;
    }
    
}
