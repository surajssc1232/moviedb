package com.moviedb.moviedb.Enitity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser app_user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}