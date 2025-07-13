package com.LavaCandy.Personal.Task.Manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LavaCandy.Personal.Task.Manager.model.*;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

    // Custom query to find boards by owner
    List<Board> findByOwner(User owner);
}