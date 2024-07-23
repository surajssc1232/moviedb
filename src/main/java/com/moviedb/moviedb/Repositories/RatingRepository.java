package com.moviedb.moviedb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviedb.moviedb.Enitity.Rating;
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
