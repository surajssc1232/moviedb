package com.moviedb.moviedb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.moviedb.moviedb.Enitity.Movie;
import com.moviedb.moviedb.Services.MovieApiClient;

import reactor.core.publisher.Mono;

@RestController
public class MovieController {
    @Autowired
    MovieApiClient movieApiClient;

    @GetMapping("/movie/{id}")
    public Mono<Movie> getMovie(@PathVariable long id){
        
        return movieApiClient.getMovieById(id);
    }

    

}
