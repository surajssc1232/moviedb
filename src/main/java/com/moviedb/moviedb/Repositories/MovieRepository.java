package com.moviedb.moviedb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviedb.moviedb.Enitity.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}