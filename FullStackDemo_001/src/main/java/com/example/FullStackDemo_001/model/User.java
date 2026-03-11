package com.example.FullStackDemo_001.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "userData")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private LocalDateTime DOB;
    private String address;
    private String currentCompany;
    private String[] skills;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;


}
