package com.example.milestonemindmobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // 1. Link UI elements to match your Maroon-themed XML
        val firstNameField = findViewById<EditText>(R.id.etRegFirstName)
        val lastNameField = findViewById<EditText>(R.id.etRegLastName)
        val emailField = findViewById<EditText>(R.id.etRegEmail)
        val passwordField = findViewById<EditText>(R.id.etRegPassword)
        val registerButton = findViewById<Button>(R.id.btnRegister)
        val loginLink = findViewById<TextView>(R.id.tvGoToLogin) // Matches .auth-footer

        // 2. Handle Registration Logic (Matches React axios.post)
        registerButton.setOnClickListener {
            val fName = firstNameField.text.toString()
            val lName = lastNameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            // Simple validation
            if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                try {
                    // This matches your React state object exactly
                    val request = RegisterRequest(fName, lName, email, password)
                    val response = RetrofitClient.instance.registerUser(request)

                    if (response.isSuccessful) {
                        Toast.makeText(this@RegisterActivity, "Account Created!", Toast.LENGTH_SHORT).show()
                        finish() // Equivalent to navigate("/login")
                    } else {
                        Toast.makeText(this@RegisterActivity, "Registration Failed", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    // Ensure your Spring Boot backend is running in VS Code
                    Toast.makeText(this@RegisterActivity, "Connection Error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }

        // 3. Navigation to Login screen (Matches React <Link to="/login">)
        loginLink.setOnClickListener {
            finish() // Closes this activity and returns to MainActivity
        }
    }
}