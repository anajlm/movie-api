package com.anajlm.movieapi.dto.request;

import java.util.Objects;

public class CreateDirectorRequest {

    private String name;

    public CreateDirectorRequest(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
