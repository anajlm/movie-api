package com.anajlm.movieapi.controller;

import com.anajlm.movieapi.domain.*;
import com.anajlm.movieapi.dto.UserPostRequest;
import com.anajlm.movieapi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(optionalUser.get());
    }

    @GetMapping("/users/{id}/reviews")
    public ResponseEntity<List<Review>> getUserReviews(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Review> reviews = optionalUser.get().getReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("users/{id}/lists")
    public ResponseEntity<List<MovieList>> getUserMovieLists(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<MovieList> movieLists = optionalUser.get().getMovieLists();
        return ResponseEntity.ok(movieLists);
    }

    @GetMapping("users/{id}/watchlist/movies")
    public ResponseEntity<List<Movie>> getUserWatchlist(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Movie> watchlistMovies = optionalUser.get().getWatchlist().getMovies();
        return ResponseEntity.ok(watchlistMovies);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserPostRequest userRequest){
        User newUser = modelMapper.map(userRequest, User.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(newUser));
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
