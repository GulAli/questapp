package com.project.questapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.User;
import com.project.questapp.services.UserService;

/**********************************************
    -HINTS-
    1. By using "RestController" ...

    2. Main path name of UserController is "/users"

    3. Constructer injection is a way to initialize
    our repository done by spring.
    Also see -> @Autowired annotation

    4. When something is needed to be created, 
    "PostMapping" annotation is used and "createrUser"
    method is called.
    
    5. By using "RequestBody", we copy the information of
    the request and map it to user objcet and return it.
**********************************************/ 

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    // Constructer Injection
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        // Custom exception
        return userService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser){
        return userService.updateOneUser(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleById(userId);
    }
}
