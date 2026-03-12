package com.example.FullStackDemo_001.service;

import com.example.FullStackDemo_001.model.User;
import com.example.FullStackDemo_001.response.Response;

import java.util.List;

public interface UserService {
    public Response saveUser(User user);
    public Response getUser(String email,String password);
    public void followUser(int followerId, int followingId);
    public List<User> getFollowers(int userId);
    public List<User> getFollowing(int userId);
}
