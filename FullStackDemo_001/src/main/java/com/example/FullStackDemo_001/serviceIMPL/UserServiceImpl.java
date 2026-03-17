package com.example.FullStackDemo_001.serviceIMPL;

import com.example.FullStackDemo_001.model.Follow;
import com.example.FullStackDemo_001.model.User;
import com.example.FullStackDemo_001.repository.FollowRepository;
import com.example.FullStackDemo_001.repository.UserRepository;
import com.example.FullStackDemo_001.response.Response;
import com.example.FullStackDemo_001.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FollowRepository followRepository;
    UserServiceImpl(UserRepository userRepository,FollowRepository followRepository){
        this.userRepository=userRepository;
        this.followRepository=followRepository;
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
    @Override
    public void followUser(int followerId, int followingId) {

        User follower = userRepository.findById(followerId).orElseThrow();
        User following = userRepository.findById(followingId).orElseThrow();

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);

        followRepository.save(follow);
    }
    @Override
    public List<User> getFollowers(int userId){
        User user= userRepository.findById(userId).orElseThrow();
        List<Follow> follows= followRepository.findByFollowing(user);
        return follows
                .stream()
                .map(Follow::getFollower)
                .toList();
    }
    @Override
    public List<User> getFollowing(int userId){
        User user= userRepository.findById(userId).orElseThrow();
        List<Follow> follows=followRepository.findByFollower(user);
             return follows
                .stream()
                .map(Follow::getFollowing)
                .toList();

    }

    public List<User> saveAllUser(List<User> usrs){
        return userRepository.saveAll(usrs);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getuserById(int id){
        return userRepository.findById(id).get();
    }


}
