package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User setUserByEmail(String email){
        User user =  userRepository.findByEmail(email);
        System.out.println("Origin User: ");
        System.out.println(user);
        List<String> roles = List.of("weqwe","qweqwe","eerwe","lfsdf","sdfsd","xccvs");
        user.setRoles(roles);
        return user;
    }
}
