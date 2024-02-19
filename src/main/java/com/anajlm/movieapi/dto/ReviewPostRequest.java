package com.anajlm.movieapi.dto;

import com.anajlm.movieapi.domain.Movie;

import java.time.LocalDate;

public class ReviewPostRequest {

    private Movie movie;

    private String reviewText;

    private int starRating; // 1 to 5 stars

    private LocalDate watchedDate;
}
