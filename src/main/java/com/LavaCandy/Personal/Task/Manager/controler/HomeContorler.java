package com.LavaCandy.Personal.Task.Manager.controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeContorler {
    
    @GetMapping("/")
    public String hello(HttpServletRequest request){
        String a = request.getSession().getId();
        return "Hello \n\n"+ a;
    }
}
