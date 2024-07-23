package com.moviedb.moviedb.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.moviedb.moviedb.Enitity.Movie;

import reactor.core.publisher.Mono;

@Service
public class MovieApiClient {
    private final WebClient webClient;

    public MovieApiClient(@Value("${movie.api.key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl("http://www.omdbapi.com/")
                .defaultHeader("apikey", apiKey)
                .build();
    }

    public Mono<Movie> getMovieById(long id) {
        return webClient.get()
                .uri("/movies/{id}", id)
                .retrieve()
                .bodyToMono(Movie.class);
    }

   
}