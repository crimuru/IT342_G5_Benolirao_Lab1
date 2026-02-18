package com.example.milestonemindmobile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardActivity : AppCompatActivity() {

    private lateinit var adapter: AchievementAdapter
    private var milestones = mutableListOf(
        Achievement(1, "First 10km Run", "2026-02-01", "Completed in 55 minutes at the local park."),
        Achievement(2, "React Certification", "2026-01-15", "Passed the advanced hooks and state management exam."),
        Achievement(3, "Read 5 Books", "2026-01-10", "Finished the monthly reading goal ahead of schedule.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val recyclerView = findViewById<RecyclerView>(R.id.rvAchievements)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
        // NEW: Profile Button
        val btnProfile = findViewById<ImageView>(R.id.btnProfile)

        // 1. Setup RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = AchievementAdapter(milestones,
            onDeleteClick = { id ->
                milestones.removeAll { it.id == id }
                adapter.notifyDataSetChanged()
            },
            onEditClick = { item ->
                Toast.makeText(this, "Edit: ${item.title}", Toast.LENGTH_SHORT).show()
            }
        )
        recyclerView.adapter = adapter

        // 2. Add Button Logic
        fabAdd.setOnClickListener {
            Toast.makeText(this, "Add functionality coming soon", Toast.LENGTH_SHORT).show()
        }

        // 3. NEW: Navigate to Profile
        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}