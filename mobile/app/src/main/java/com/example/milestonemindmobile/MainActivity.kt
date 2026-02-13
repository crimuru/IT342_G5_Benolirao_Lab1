package com.example.milestonemindmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Link UI elements to the code
        val emailField = findViewById<EditText>(R.id.etEmail)
        val passwordField = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val registerLink = findViewById<TextView>(R.id.tvGoToRegister)

        // 2. Handle Login Logic
        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Perform the network call in a background thread
            lifecycleScope.launch {
                try {
                    val loginRequest = LoginRequest(email, password)
                    val response = RetrofitClient.instance.loginUser(loginRequest)

                    if (response.isSuccessful) {
                        Toast.makeText(this@MainActivity, "Welcome back!", Toast.LENGTH_SHORT).show()

                        // 3. Move to the Dashboard (The Protected Screen)
                        val intent = Intent(this@MainActivity, DashboardActivity::class.java)
                        startActivity(intent)
                        finish() // Close login so 'Back' doesn't return here
                    } else {
                        Toast.makeText(this@MainActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    // Check if Spring Boot is actually running in VS Code
                    Toast.makeText(this@MainActivity, "Server Error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }

        // 4. Navigate to Register Screen
        registerLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}