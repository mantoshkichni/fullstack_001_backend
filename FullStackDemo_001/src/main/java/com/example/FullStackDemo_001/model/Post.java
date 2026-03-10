package com.example.FullStackDemo_001.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "postData")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int postId;
    int UserId;
    String title;
    String description;
    LocalDateTime createdAt;
    List<Comment> comments;
    int share;
    int like;
    int dislike;


}
