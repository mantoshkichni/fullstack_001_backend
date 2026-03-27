package com.example.FullStackDemo_001.controller;

import com.example.FullStackDemo_001.model.LogInUserData;
import com.example.FullStackDemo_001.model.Post;
import com.example.FullStackDemo_001.model.User;
import com.example.FullStackDemo_001.response.Response;
import com.example.FullStackDemo_001.serviceIMPL.PostServiceImpl;
import com.example.FullStackDemo_001.serviceIMPL.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {


    private final UserServiceImpl userService;
    private final  PostServiceImpl postService;
    Controller( UserServiceImpl userService, PostServiceImpl postService){
        this.userService=userService;
        this.postService=postService;
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

    @PostMapping("/follow")//user1/Follow/User2
    public void followUser(@RequestParam Integer followerId,
                           @RequestParam Integer followingId) {

        userService.followUser(followerId, followingId);
    }

    @GetMapping("/getAllUser")
    List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/getUserFollowers")
    List<User> getFollower(@RequestParam Integer userId){
        return userService.getFollowing(userId);
    }

    @PostMapping("/getUserFollowing")
    List<User> getFollowing(@RequestParam Integer userId){
        return userService.getFollowers(userId);
    }

    @PostMapping("/savePost")
    Response savePost(@RequestBody Post post){
        try {
            User user=userService.getuserById(post.getUser().getUserId());
            post.setUser(user);
            postService.savePost(post);
            return new Response("Success","200", user);
        } catch (Exception e) {
            return new Response(e.getMessage(),"400",new User());
        }

    }

}
