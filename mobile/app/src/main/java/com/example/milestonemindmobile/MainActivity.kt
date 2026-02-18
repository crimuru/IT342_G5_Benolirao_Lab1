package com.example.milestonemindmobile

import android.content.Context
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

        // 1. Link UI elements to match your Maroon-themed XML
        val emailField = findViewById<EditText>(R.id.etEmail)
        val passwordField = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val registerLink = findViewById<TextView>(R.id.tvGoToRegister)

        // 2. Handle Login Logic (Matches React axios.post)
        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                try {
                    // Hits your @PostMapping("/api/auth/login")
                    val loginRequest = LoginRequest(email, password)
                    val response = RetrofitClient.instance.loginUser(loginRequest)

                    if (response.isSuccessful) {
                        // Equivalent to localStorage.setItem("user", ...)
                        val sharedPref = getSharedPreferences("MilestoneMindPrefs", Context.MODE_PRIVATE)
                        with(sharedPref.edit()) {
                            putString("user_email", email)
                            putBoolean("isLoggedIn", true)
                            apply()
                        }

                        // SUCCESS: Just show a message, do not try to open Dashboard yet
                        Toast.makeText(this@MainActivity, "Login Success!", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(this@MainActivity, "Invalid email or password", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    // Ensure you are using http://10.0.2.2:8080/ for Emulator
                    Toast.makeText(this@MainActivity, "Server Error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }

        // 3. Navigate to Register Screen (Matches React <Link to="/register">)
        registerLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}