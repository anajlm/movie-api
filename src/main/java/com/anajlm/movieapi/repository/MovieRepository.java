package com.anajlm.movieapi.repository;

import com.anajlm.movieapi.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitleIgnoreCase(String title);
}
