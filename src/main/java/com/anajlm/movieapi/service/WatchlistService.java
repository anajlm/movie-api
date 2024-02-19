package com.anajlm.movieapi.service;

import com.anajlm.movieapi.domain.Movie;
import com.anajlm.movieapi.domain.User;
import com.anajlm.movieapi.domain.Watchlist;
import com.anajlm.movieapi.repository.WatchlistRepository;

import java.util.List;

public class WatchlistServer {


    private WatchlistRepository watchlistRepository;

    public List<Movie> getAllMoviesInWatchlist(User user) {
        Watchlist watchlist = watchlistRepository.findByUser(user);
        if (watchlist != null) {
            return watchlist.getMovies();
        }
        return Collections.emptyList();
    }

}
