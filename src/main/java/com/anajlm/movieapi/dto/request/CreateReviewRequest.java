package com.anajlm.movieapi.dto.request;

import com.anajlm.movieapi.domain.Movie;

import java.time.LocalDate;

public class CreateReviewRequest {

    private Movie movie;

    private String reviewText;

    private int starRating; // 1 to 5 stars

    private LocalDate watchedDate;
}
