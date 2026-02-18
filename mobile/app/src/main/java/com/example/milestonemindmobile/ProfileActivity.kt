
package com.example.milestonemindmobile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etBirthDate: EditText

    private lateinit var btnEditToggle: Button
    private lateinit var layoutActions: LinearLayout
    private lateinit var btnCancel: Button
    private lateinit var btnSave: Button
    private lateinit var btnLogout: Button

    private lateinit var tvFullName: TextView
    private lateinit var tvDisplayEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 1. SECURITY: Redirect if not logged in
        val sharedPref = getSharedPreferences("MilestoneMindPrefs", Context.MODE_PRIVATE)
        if (!sharedPref.getBoolean("isLoggedIn", false)) {
            redirectToLogin()
            return
        }

        // 2. Initialize Views
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etEmail = findViewById(R.id.etEmail)
        etBirthDate = findViewById(R.id.etBirthDate)

        btnEditToggle = findViewById(R.id.btnEditToggle)
        layoutActions = findViewById(R.id.layoutActions)
        btnCancel = findViewById(R.id.btnCancel)
        btnSave = findViewById(R.id.btnSave)
        btnLogout = findViewById(R.id.btnLogout)

        tvFullName = findViewById(R.id.tvFullName)
        tvDisplayEmail = findViewById(R.id.tvDisplayEmail)

        // 3. Load Data
        loadUserData()

        // 4. Click Listeners
        btnEditToggle.setOnClickListener { toggleEditMode(true) }

        btnCancel.setOnClickListener {
            toggleEditMode(false)
            loadUserData() // Revert changes
        }

        btnSave.setOnClickListener {
            saveUserData()
            toggleEditMode(false)
            Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            with(sharedPref.edit()) {
                clear()
                apply()
            }
            redirectToLogin()
        }
    }

    private fun toggleEditMode(isEditing: Boolean) {
        etFirstName.isEnabled = isEditing
        etLastName.isEnabled = isEditing
        etEmail.isEnabled = isEditing
        etBirthDate.isEnabled = isEditing

        if (isEditing) {
            btnEditToggle.visibility = View.GONE
            layoutActions.visibility = View.VISIBLE
            etFirstName.requestFocus()
        } else {
            btnEditToggle.visibility = View.VISIBLE
            layoutActions.visibility = View.GONE
        }
    }

    private fun loadUserData() {
        val sharedPref = getSharedPreferences("MilestoneMindPrefs", Context.MODE_PRIVATE)

        // Defaults are EMPTY STRINGS now
        val email = sharedPref.getString("user_email", "No Email")
        val first = sharedPref.getString("first_name", "")
        val last = sharedPref.getString("last_name", "")
        val birthDate = sharedPref.getString("birth_date", "")

        etEmail.setText(email)
        etFirstName.setText(first)
        etLastName.setText(last)
        etBirthDate.setText(birthDate)

        // Update Header Box
        if (first.isNullOrEmpty() && last.isNullOrEmpty()) {
            tvFullName.text = "New User"
        } else {
            tvFullName.text = "$first $last"
        }
        tvDisplayEmail.text = email
    }

    private fun saveUserData() {
        val sharedPref = getSharedPreferences("MilestoneMindPrefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("first_name", etFirstName.text.toString())
            putString("last_name", etLastName.text.toString())
            putString("user_email", etEmail.text.toString())
            putString("birth_date", etBirthDate.text.toString())
            apply()
        }
        loadUserData() // Refresh UI
    }

    private fun redirectToLogin() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}