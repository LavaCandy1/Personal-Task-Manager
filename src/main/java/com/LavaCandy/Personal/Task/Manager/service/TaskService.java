package com.LavaCandy.Personal.Task.Manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LavaCandy.Personal.Task.Manager.repository.*;
import com.LavaCandy.Personal.Task.Manager.model.*;

import java.util.Optional;
import java.util.List;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private BoardRepository boardRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    
    public Task createTask(Task task, Board board) {
        if (board != null) {
            task.setBoard(board);
            return taskRepository.save(task);
        }
        return null;
    }
    
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }


    public Task updateTask(Long id, Task task){
        Optional<Task> existingTask = taskRepository.findById(id);
        if(existingTask.isPresent()){
            Task updatedTask = existingTask.get();

            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setCompletion(task.getCompletion());
            updatedTask.setDueDate(task.getDueDate());
            updatedTask.setBoard(task.getBoard());
            return taskRepository.save(updatedTask);
        }else{
            return null;
        }
    }

    public List<Task> getTaskByBoardId(Long boardId) {
        Board currBoard = boardRepository.findById(boardId).orElse(null);

        if(currBoard != null) {
            return taskRepository.findByBoard(currBoard);
        } else {
            return null;
        }
    }
    
    public Task toggleTaskCompletion(Long taskId){
        Task currtask = taskRepository.findById(taskId).orElse(null);
        
        if(currtask != null){
            currtask.setCompletion(!currtask.getCompletion());
            return taskRepository.save(currtask);
        }else{
            return null;
        }
        
    }

}
