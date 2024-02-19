package com.anajlm.movieapi.dto.request;

import java.util.Objects;

public class RemoveMovieFromListRequest {

    private String title;

    public RemoveMovieFromListRequest(String title){
        this.title = Objects.requireNonNull(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
