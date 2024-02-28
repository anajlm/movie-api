package com.anajlm.movieapi.controller;

import com.anajlm.movieapi.domain.Director;
import com.anajlm.movieapi.domain.Movie;
import com.anajlm.movieapi.domain.Review;
import com.anajlm.movieapi.dto.request.CreateMovieRequest;
import com.anajlm.movieapi.dto.request.CreateReviewRequest;
import com.anajlm.movieapi.exception.MovieNotFoundException;
import com.anajlm.movieapi.repository.DirectorRepository;
import com.anajlm.movieapi.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final ModelMapper modelMapper;

    public MovieController(MovieRepository movieRepository, DirectorRepository directorRepository, ModelMapper modelMapper){
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        return ResponseEntity.ok().body(movie);
    }

    @GetMapping(value = "/movies", params = {"title"})
    public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title){
        return ResponseEntity.ok(movieRepository.findByTitleIgnoreCase(title));
    }

    @GetMapping(value = "/movies", params = {"director"})
    public ResponseEntity<Movie> getMovieByDirector(@RequestParam String directorName){
        Director director = directorRepository.findByName(directorName);
    }

    @GetMapping("/movies/{id}/reviews")
    public ResponseEntity<List<Review>> getUserReviewsForAMovie(@PathVariable Long id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        List<Review> reviews = movie.getReviews();
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody CreateMovieRequest movieRequest){
        Movie newMovie = modelMapper.map(movieRequest, Movie.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieRepository.save(newMovie));
    }

    @PostMapping("/movies/{id}/add_review")
    public ResponseEntity<Review> addReviewToMovie(@PathVariable Long id, @RequestParam Long userId, @RequestBody CreateReviewRequest reviewRequest){
        Review review = modelMapper.map(reviewRequest, Review.class);

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));

        List<Review> reviews = movie.getReviews();
        reviews.add(review);
        movie.setReviews(reviews);
        movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

}
