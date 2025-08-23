package com.LavaCandy.Personal.Task.Manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


@Entity
public class Task {
    
    //attributes - features
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;
    private String dueDate;
    
    @ManyToOne
    @JsonBackReference
    private Board board;

    //getters
    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public Boolean getCompletion(){
        return completed;
    }
    public String getDueDate(){
        return dueDate;
    }
    public Board getBoard(){
        return board;
    }

    //setters
    public void setId(Long id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCompletion(Boolean completed){
        this.completed = completed;
    }
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }
    public void setBoard(Board board){
        this.board = board;
    }

}
