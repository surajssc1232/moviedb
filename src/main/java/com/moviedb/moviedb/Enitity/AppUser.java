package com.moviedb.moviedb.Enitity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "app_user")
    private List<Rating> ratings;

    // Getters and setters
}