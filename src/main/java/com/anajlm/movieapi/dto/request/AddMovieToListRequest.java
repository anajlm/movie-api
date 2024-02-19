package com.anajlm.movieapi.dto.request;

import java.util.Objects;

public class AddMovieToListRequest {

    private String title;

    public AddMovieToListRequest(String title){
        this.title = Objects.requireNonNull(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
