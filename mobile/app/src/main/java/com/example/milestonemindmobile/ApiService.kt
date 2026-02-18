package com.example.milestonemindmobile

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    // Matches your Spring Boot @PostMapping("/api/auth/login")
    @POST("api/auth/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<Unit>

    // Matches your Spring Boot @PostMapping("/api/auth/register")
    @POST("api/auth/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest): Response<Unit>

    // Requirement: Logout functionality for Lab 3
    @POST("api/auth/logout")
    suspend fun logoutUser(): Response<Unit>
}

// These match the DTOs in your Spring Boot project exactly
data class LoginRequest(
    val email: String,
    val password: String
)

data class RegisterRequest(
    val firstName: String, // Matches React and User.java
    val lastName: String,  // Matches React and User.java
    val email: String,
    val password: String
)