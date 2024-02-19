package com.anajlm.movieapi.controller;

import com.anajlm.movieapi.domain.Movie;
import com.anajlm.movieapi.domain.Review;
import com.anajlm.movieapi.dto.request.MoviePostRequest;
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
    private final ModelMapper modelMapper;

    public MovieController(MovieRepository movieRepository, ModelMapper modelMapper){
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(!optionalMovie.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(optionalMovie.get());
    }

    @GetMapping(value = "/movies", params = {"title"})
    public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title){
        return ResponseEntity.ok(movieRepository.findByTitleIgnoreCase(title));
    }

    @GetMapping("/movies/{id}/reviews")
    public ResponseEntity<List<Review>> getMovieReviews(@PathVariable Long id){
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(!optionalMovie.isPresent()){
            return ResponseEntity.notFound().build();
        }
        List<Review> reviews = optionalMovie.get().getReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("movies/{id}/lists")


    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody MoviePostRequest movieRequest){
        Movie newMovie = modelMapper.map(movieRequest, Movie.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieRepository.save(newMovie));
    }

}
