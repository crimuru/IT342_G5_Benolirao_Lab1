package com.achievement.backend.controller;

import com.achievement.backend.model.User;
import com.achievement.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET /api/user/me
    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body("Error: Not authenticated");
        }

        // Fetch the full user details from the database using the email/username from the session
        Optional<User> user = userRepository.findByEmail(userDetails.getUsername());
        
        return user.isPresent() 
            ? ResponseEntity.ok(user.get()) 
            : ResponseEntity.status(404).body("User not found");
    }
}