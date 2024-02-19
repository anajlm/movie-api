package com.anajlm.movieapi.controller;

import com.anajlm.movieapi.domain.Movie;
import com.anajlm.movieapi.domain.User;
import com.anajlm.movieapi.domain.Watchlist;
import com.anajlm.movieapi.exception.UserNotFoundException;
import com.anajlm.movieapi.repository.MovieRepository;
import com.anajlm.movieapi.repository.UserRepository;
import com.anajlm.movieapi.service.UserService;
import com.anajlm.movieapi.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WatchlistController {

    private final WatchlistService watchlistService;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public WatchlistController(WatchlistService watchlistService, UserRepository userRepository, MovieRepository movieRepository){
        this.watchlistService = watchlistService;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }


    @GetMapping("/{userId}/watchlist/movies")
    public ResponseEntity<List<Movie>> getAllMoviesInWatchlist(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        List<Movie> movies = watchlistService.getAllMoviesInWatchlist(user);
        return ResponseEntity.ok().body(movies);
    }


    @PostMapping("/{userId}/watchlist/movies")
    public ResponseEntity<Movie> insertMovieOnWatchlist(@PathVariable Long userId, @RequestBody ){
        WatchlistPostRequest watchlistDTO = watchlistService.addToWatchList(userId, movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(watchlistDTO);
    }

    @DeleteMapping("/{userId}/watchlist/movies")
    public ResponseEntity<Watchlist> deleteMovieFromWatchlist(@PathVariable Long userId, @RequestBody ){
        watchlistService.removeFromWatchlist(userId, movieId);
        if(!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
