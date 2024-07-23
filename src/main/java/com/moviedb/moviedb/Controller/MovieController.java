package com.moviedb.moviedb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.moviedb.moviedb.Services.MovieApiClient;

import reactor.core.publisher.Mono;

@RestController
public class MovieController {
    @Autowired
    MovieApiClient movieApiClient;

    @GetMapping("/movie/{imdbId}")
    public Mono<String> getMovie(@PathVariable String imdbId) {
        return movieApiClient.getMovieById(imdbId);
    }



}
