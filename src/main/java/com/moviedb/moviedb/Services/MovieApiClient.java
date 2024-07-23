package com.moviedb.moviedb.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.Data;
import reactor.core.publisher.Mono;
@Data
@Service
public class MovieApiClient {
    private static final Logger logger = LoggerFactory.getLogger(MovieApiClient.class);
    
    private final WebClient webClient;
    private final String apiKey;

    public MovieApiClient() {
        this.apiKey = "30e9df3f";  // Hardcoded for testing
        this.webClient = WebClient.builder()
                .baseUrl("http://www.omdbapi.com/")
                .build();
        
        logger.info("API Key: {}", apiKey);
    }

    public Mono<String> getMovieById(String imdbId) {
        String url = String.format("http://www.omdbapi.com/?apikey=%s&i=%s", apiKey, imdbId);
        logger.info("Requesting URL: {}", url);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .queryParam("apikey", apiKey)
                    .queryParam("i", imdbId)
                    .build())
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(response -> logger.info("Response: {}", response))
                .doOnError(error -> logger.error("Error fetching movie: {}", error.getMessage()));
    }
}