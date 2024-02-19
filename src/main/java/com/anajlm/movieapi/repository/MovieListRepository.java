package com.anajlm.movieapi.repository;

import com.anajlm.movieapi.domain.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieListRepository extends JpaRepository<MovieList, Long> {
}
