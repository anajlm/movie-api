package com.anajlm.movieapi.domain;

import com.anajlm.movieapi.domain.enums.Genre;
import jakarta.persistence.*;

import java.time.Year;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Director director;

    private Year releaseYear;

    private Genre genre;

    @OneToMany
    private List<Review> reviews;

    @ManyToMany
    private List<MovieList> movieLists;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<MovieList> getMovieLists() {
        return movieLists;
    }

    public void setMovieLists(List<MovieList> movieLists) {
        this.movieLists = movieLists;
    }
}
