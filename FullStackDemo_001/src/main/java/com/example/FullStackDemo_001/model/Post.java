package com.example.FullStackDemo_001.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "postData")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int postId;
    String title;
    @Column(columnDefinition = "TEXT")
    String description;
    String urlToImage;
    OffsetDateTime createdAt;
    @JsonManagedReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<Comment> comments;
    int shares;
    int likes;
    int dislikes;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
