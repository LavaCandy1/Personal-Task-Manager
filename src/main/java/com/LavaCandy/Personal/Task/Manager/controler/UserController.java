package com.LavaCandy.Personal.Task.Manager.controler;

import com.LavaCandy.Personal.Task.Manager.dto.UserRequestDTO;
import com.LavaCandy.Personal.Task.Manager.dto.UserResponseDTO;
import com.LavaCandy.Personal.Task.Manager.model.*;
import com.LavaCandy.Personal.Task.Manager.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BoardService boardService;


    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id ) {
        UserResponseDTO userResponseDTO = userService.getUserById(id);
        if(userResponseDTO != null) {
            return ResponseEntity.ok(userResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.updateUser(id, userRequestDTO);
        if(userResponseDTO != null) {
            return ResponseEntity.ok(userResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/boards")
    public ResponseEntity<List<Board>> getUserBoards(@PathVariable Long id) {
        UserResponseDTO currUserResponseDTO = userService.getUserById(id);

        if(currUserResponseDTO != null){
            return ResponseEntity.ok(boardService.getBoardsByOwner(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
