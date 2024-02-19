package com.anajlm.movieapi.dto;

import java.util.Objects;

public class DirectorPostRequest {

    private String name;

    public DirectorPostRequest(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
