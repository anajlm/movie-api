package com.anajlm.movieapi.repository;

import com.anajlm.movieapi.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Director findByName(String name);
}
