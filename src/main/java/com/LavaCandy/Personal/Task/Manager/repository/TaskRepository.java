package com.LavaCandy.Personal.Task.Manager.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.LavaCandy.Personal.Task.Manager.model.*;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
