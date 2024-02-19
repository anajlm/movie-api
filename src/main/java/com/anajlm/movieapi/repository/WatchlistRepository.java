package com.anajlm.movieapi.repository;

import com.anajlm.movieapi.domain.User;
import com.anajlm.movieapi.domain.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    Watchlist findByUser(User user);
}
