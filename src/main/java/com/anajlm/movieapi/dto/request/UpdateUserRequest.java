package com.anajlm.movieapi.dto.request;

import java.util.Objects;

public class UpdateUserRequest {

    private String password;

    public UpdateUserRequest(String password) {
        this.password = Objects.requireNonNull(password);
    }

    public String getPassword() {
        return password;
    }
}
