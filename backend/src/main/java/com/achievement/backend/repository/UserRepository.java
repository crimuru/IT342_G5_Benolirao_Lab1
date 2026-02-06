package com.achievement.backend.repository;

import com.achievement.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method to find a user by email for the Login requirement
    Optional<User> findByEmail(String email);
}