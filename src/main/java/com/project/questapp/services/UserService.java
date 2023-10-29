package com.project.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;

/**********************************************
    -HINTS-
    1. Connecting a repository to a controller is a thing
    that works just normal but it is not preferred. By
    connecting a repository to a controller, we are 
    forced to use some business logics inside of 
    controller. We need to use this business logic 
    inside of services. Structre should be like:

    Database > repository > service  > controller > API/UI

    2. By using "service" annotation, we indicate that
    we want to do related business logic inside of service.

**********************************************/ 

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);

            return foundUser;
        }
        else{
            return null;
        }
    }

    public void deleById(Long userId) {
        userRepository.deleteById(userId);
    }
}