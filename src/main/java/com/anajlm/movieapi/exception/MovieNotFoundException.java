package com.anajlm.movieapi.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id){
        super("Could not find movie with id: " + id);
    }
}