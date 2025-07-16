package com.LavaCandy.Personal.Task.Manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LavaCandy.Personal.Task.Manager.model.Board;
import com.LavaCandy.Personal.Task.Manager.repository.BoardRepository;
import com.LavaCandy.Personal.Task.Manager.model.User;
import com.LavaCandy.Personal.Task.Manager.repository.UserRepository;

import java.util.List;

@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private UserRepository userRepository;

    
    public List<Board> getAllBoards(){
        return boardRepository.findAll();
    }

    public Board deleteBoard(Long id) {
        Board board = boardRepository.findById(id).orElse(null);
        if (board != null) {
            boardRepository.deleteById(id);
            return board;
        }
        return null;
    }

    public Board createBoard(Board board, Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            board.setOwner(user);
            return boardRepository.save(board);
        }
        return null;
    }

    public List<Board> getBoardsByOwner(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return boardRepository.findByOwner(user);
        }
        return null;
    }

    public Board getBoardById(Long boardId){
        return boardRepository.findById(boardId).orElse(null);        
    }
}
