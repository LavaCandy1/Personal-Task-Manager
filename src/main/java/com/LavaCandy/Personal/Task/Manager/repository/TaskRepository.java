package com.LavaCandy.Personal.Task.Manager.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.LavaCandy.Personal.Task.Manager.model.*;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByBoard(Board board);
}
