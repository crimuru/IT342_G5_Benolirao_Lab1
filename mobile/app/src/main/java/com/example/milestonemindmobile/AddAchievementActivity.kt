package com.example.milestonemindmobile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddAchievementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_achievement)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etDate = findViewById<EditText>(R.id.etDate)
        val etDesc = findViewById<EditText>(R.id.etDesc)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val date = etDate.text.toString()
            val desc = etDesc.text.toString()

            if (title.isNotEmpty() && date.isNotEmpty()) {
                // 1. Create a new Achievement Object
                // We use a random ID for now (or System time)
                val newAchievement = Achievement(
                    id = System.currentTimeMillis().toInt(),
                    title = title,
                    date = date,
                    description = desc
                )

                // 2. Send it back to Dashboard
                val resultIntent = Intent()
                resultIntent.putExtra("new_achievement", newAchievement)
                setResult(Activity.RESULT_OK, resultIntent)

                finish() // Close this screen
            } else {
                Toast.makeText(this, "Please enter a title and date", Toast.LENGTH_SHORT).show()
            }
        }
    }
}