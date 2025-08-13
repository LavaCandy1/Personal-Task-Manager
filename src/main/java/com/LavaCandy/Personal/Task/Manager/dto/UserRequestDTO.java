package com.LavaCandy.Personal.Task.Manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;


public class UserRequestDTO {

    @NotBlank(message = "Username cannot be blank")
    private String name;

    @Email
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //getters
    public String getName(){
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    
    public String toString() {
        return "UserRequestDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
