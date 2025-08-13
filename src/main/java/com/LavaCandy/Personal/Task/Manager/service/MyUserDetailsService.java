package com.LavaCandy.Personal.Task.Manager.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.LavaCandy.Personal.Task.Manager.model.User;
import com.LavaCandy.Personal.Task.Manager.model.UserPrincipal;
import com.LavaCandy.Personal.Task.Manager.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

        User user = userRepository.findByEmail(email);

        if(user == null) {
            System.out.println("User not Found");
            throw new UsernameNotFoundException("User not found with email: " + email);
        } else {
            return new UserPrincipal(user);
        }
    }
}
