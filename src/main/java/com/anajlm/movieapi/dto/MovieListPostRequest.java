package com.anajlm.movieapi.dto;

import com.anajlm.movieapi.domain.Movie;
import com.anajlm.movieapi.domain.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;
import java.util.Objects;

public class MovieListPostRequest {

    private String name;

    private User user;

    public MovieListPostRequest(String name, User user) {
        this.name = Objects.requireNonNull(name);
        this.user = Objects.requireNonNull(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
