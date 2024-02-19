package com.anajlm.movieapi.repository;

import com.anajlm.movieapi.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
