package com.example.FullStackDemo_001.service;

import com.example.FullStackDemo_001.model.User;
import com.example.FullStackDemo_001.response.Response;

public interface UserService {
    public Response saveUser(User user);
    public Response getUser(String email,String password);
}
