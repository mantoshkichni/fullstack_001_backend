package com.example.FullStackDemo_001.repository;

import com.example.FullStackDemo_001.model.Follow;
import com.example.FullStackDemo_001.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow,Integer> {
    List<Follow> findByFollowing(User user);
    List<Follow> findByFollower(User user);
}
