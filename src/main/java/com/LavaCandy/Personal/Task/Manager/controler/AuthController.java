package com.LavaCandy.Personal.Task.Manager.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LavaCandy.Personal.Task.Manager.dto.UserRequestDTO;
import com.LavaCandy.Personal.Task.Manager.dto.UserResponseDTO;
import com.LavaCandy.Personal.Task.Manager.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    


    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO createdUser = userService.createUser(userRequestDTO);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserRequestDTO userRequestDTO) {

        String token = userService.verifyUser(userRequestDTO);

        return ResponseEntity.ok(token);
    }
}
