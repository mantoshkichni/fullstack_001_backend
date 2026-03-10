package com.example.FullStackDemo_001.serviceIMPL;

import com.example.FullStackDemo_001.model.User;
import com.example.FullStackDemo_001.repository.UserRepository;
import com.example.FullStackDemo_001.response.Response;
import com.example.FullStackDemo_001.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public Response saveUser(User user) {
        Response response;
        try {
            userRepository.save(user);
             response= new Response("User added Successfuly.", "200");
        } catch (RuntimeException e) {
            return new Response(e.getMessage(),"400");
        }
        return response;
    }

    @Override
    public Response getUser(String email, String password) {
        Optional<User>  userOptional= userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
            return new Response("Email not Exist","400");
        }
        User user=userOptional.get();
        if(user.getPassword().equals(password)){
            return  new Response("Login Successful","200");
        }else{
            return new Response("Invalid password","400");
        }
    }
}
