package com.example.FullStackDemo_001.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "commentData")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commentId;
    String comment;
    LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Post post;
}
