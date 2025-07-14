package com.LavaCandy.Personal.Task.Manager.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LavaCandy.Personal.Task.Manager.service.*;
import com.LavaCandy.Personal.Task.Manager.model.*;

@RestController
@RequestMapping("/boards")
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards(){
        return ResponseEntity.ok(boardService.getAllBoards());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Board> createBoard(@RequestBody Board board,@PathVariable Long userId){
        Board createdBoard = boardService.createBoard(board, userId);
        if(createdBoard != null){
            return ResponseEntity.ok(createdBoard);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long id) {
        Board deletedBoard = boardService.deleteBoard(id); 
        if(deletedBoard != null) {
            return ResponseEntity.ok(deletedBoard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getTaskByBoard(@PathVariable Long id){

        List<Task> allTasks = taskService.getTaskByBoardId(id);

        if(allTasks != null){
            return ResponseEntity.ok(allTasks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
