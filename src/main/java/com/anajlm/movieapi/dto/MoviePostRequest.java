package com.anajlm.movieapi.dto;

import com.anajlm.movieapi.domain.Director;
import com.anajlm.movieapi.domain.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoviePostRequest {

    private String title;

    private Year releaseYear;

    private Director director;

    private Genre genre;

    public MoviePostRequest(String title, Year releaseYear, Director director, Genre genre) {
        this.title = Objects.requireNonNull(title);
        this.releaseYear = Objects.requireNonNull(releaseYear);
        this.genre = Objects.requireNonNull(genre);
        this.director = Objects.requireNonNull(director);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
