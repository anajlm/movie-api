package com.anajlm.movieapi.service;

import com.anajlm.movieapi.domain.Movie;
import com.anajlm.movieapi.domain.User;
import com.anajlm.movieapi.domain.Watchlist;
import com.anajlm.movieapi.repository.MovieRepository;
import com.anajlm.movieapi.repository.UserRepository;
import com.anajlm.movieapi.repository.WatchlistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class WatchlistService {


    private final WatchlistRepository watchlistRepository;
    private  UserRepository userRepository;
    private MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WatchlistService(WatchlistRepository watchlistRepository, ModelMapper modelMapper){
        this.watchlistRepository = watchlistRepository;
        this.modelMapper = modelMapper;
    }

    public List<Movie> getAllMoviesInWatchlist(User user) {
        Watchlist watchlist = watchlistRepository.findByUser(user);
        if (watchlist != null) {
            return watchlist.getMovies();
        }
        return Collections.emptyList();
    }

    public WatchlistDTO addToWatchlist(Long userId, Long movieId){
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);

        Watchlist watchlist = watchlistRepository.findByUser(optionalUser.get());
        watchlist.getMovies().add(optionalMovie.get());
        watchlistRepository.save(watchlist);

        return modelMapper.map(watchlist, WatchlistDTO.class);''
    }

    public void removeFromWatchlist(Long userId, Long movieId){
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);

        Watchlist watchlist = watchlistRepository.findByUser(optionalUser.get());
        watchlist.getMovies().remove(optionalMovie.get());
        watchlistRepository.save(watchlist);
    }

}
