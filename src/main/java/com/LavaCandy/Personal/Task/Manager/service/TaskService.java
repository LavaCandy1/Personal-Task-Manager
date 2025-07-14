package com.LavaCandy.Personal.Task.Manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LavaCandy.Personal.Task.Manager.repository.TaskRepository;
import com.LavaCandy.Personal.Task.Manager.model.Task;

import java.util.Optional;
import java.util.List;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
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
}
