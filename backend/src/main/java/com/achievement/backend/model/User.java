package com.achievement.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users") // This will be the table name in Supabase
@Data // Generates getters and setters automatically via Lombok
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password; // This will store the BCrypt hash
}