package com.anajlm.movieapi.controller;

import com.anajlm.movieapi.domain.Movie;
import com.anajlm.movieapi.domain.MovieList;
import com.anajlm.movieapi.domain.User;
import com.anajlm.movieapi.dto.AddMovieToListRequest;
import com.anajlm.movieapi.dto.MovieListPostRequest;
import com.anajlm.movieapi.repository.MovieListRepository;
import com.anajlm.movieapi.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MovieListController {

    private MovieListRepository movieListRepository;
    private MovieRepository movieRepository;
    private ModelMapper modelMapper;

    @Autowired
    public MovieListController(MovieListRepository movieListRepository, MovieRepository movieRepository, ModelMapper modelMapper){
        this.movieListRepository = movieListRepository;
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/lists/{id}")
    public ResponseEntity<MovieList> createList(@RequestBody MovieListPostRequest movieListRequest){
        MovieList movieList = modelMapper.map(movieListRequest, MovieList.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieList);
    }

    @PostMapping("/lists/{id}/add_item")
    public ResponseEntity<MovieList> addMovieToList(@PathVariable Long id, @RequestBody AddMovieToListRequest movieRequest){
        Optional<MovieList> optionalMovieList = movieListRepository.findById(id);
        Movie movie = movieRepository.findByTitleIgnoreCase(movieRequest.getTitle());
        if(!optionalMovieList.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        MovieList list = optionalMovieList.get();
        list.getMovies().add(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieListRepository.save(list));
    }

    @PostMapping("lists/{id}/remove_item")
    public ResponseEntity<MovieList> removeMovieFromList(@PathVariable Long id){
        
    }

    @DeleteMapping("/lists/{id}")
    public ResponseEntity<User> deleteList(@PathVariable Long id){
        Optional<MovieList> optionalMovieList = movieListRepository.findById(id);
        if(!optionalMovieList.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        movieListRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
