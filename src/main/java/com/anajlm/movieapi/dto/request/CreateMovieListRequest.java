package com.anajlm.movieapi.dto.request;

import com.anajlm.movieapi.domain.User;

import java.util.Objects;

public class CreateMovieListRequest {

    private String name;

    private User user;

    public CreateMovieListRequest(String name, User user) {
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
