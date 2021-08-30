package com.midas.securitybasic.domain.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);
}
