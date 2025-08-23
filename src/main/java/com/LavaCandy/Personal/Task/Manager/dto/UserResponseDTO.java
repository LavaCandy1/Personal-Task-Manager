package com.LavaCandy.Personal.Task.Manager.dto;

import com.LavaCandy.Personal.Task.Manager.model.User;

import java.util.List;

import com.LavaCandy.Personal.Task.Manager.model.Board;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<Board> boards;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.boards = user.getBoards();
    }

    // getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public List<Board> getBoard() {
        return boards;
    }
}
