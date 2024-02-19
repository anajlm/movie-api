package com.anajlm.movieapi.repository;

import com.anajlm.movieapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
