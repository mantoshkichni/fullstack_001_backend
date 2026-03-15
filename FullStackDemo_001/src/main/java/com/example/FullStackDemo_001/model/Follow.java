package com.example.FullStackDemo_001.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "followData",uniqueConstraints = @UniqueConstraint(columnNames = {"follower_id", "following_id"})
)
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "follower_id")
    @JsonIgnore
    private User follower;
    @ManyToOne
    @JoinColumn(name="following_id")
    @JsonIgnore
    private User following;
}
