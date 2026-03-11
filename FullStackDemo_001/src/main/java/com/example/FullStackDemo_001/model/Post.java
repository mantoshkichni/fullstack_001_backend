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
    String title;
    String description;
    LocalDateTime createdAt;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<Comment> comments;
    int shares;
    int likes;
    int dislikes;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
