package com.example.FullStackDemo_001.controller;

import com.example.FullStackDemo_001.model.LogInUserData;
import com.example.FullStackDemo_001.model.User;
import com.example.FullStackDemo_001.response.Response;
import com.example.FullStackDemo_001.serviceIMPL.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {


    private UserServiceImpl userService;
    Controller( UserServiceImpl userService){
        this.userService=userService;
    }

    @PostMapping("/saveUser")
    Response saveUser(@RequestBody User user){
        return userService.saveUser(user);

    }

    @PostMapping("/saveAll")
    List<User> saveAllUser(@RequestBody List<User> users){
        return userService.saveAllUser(users);

    }

    @PostMapping("/login")
    Response getUser(@RequestBody LogInUserData logInUserData){
        return userService.getUser(logInUserData.getEmail(),logInUserData.getPassword());
    }

    @PostMapping("/{followerId}/follow/{followingId}")
    public void followUser(@PathVariable int followerId,
                           @PathVariable int followingId) {

        userService.followUser(followerId, followingId);
    }

    @GetMapping("/getAllUser")
    List<User> getAllUser(){
        return userService.getAllUser();
    }
}
