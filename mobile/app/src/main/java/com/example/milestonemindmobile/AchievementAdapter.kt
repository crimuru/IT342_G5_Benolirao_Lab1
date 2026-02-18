package com.example.milestonemindmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AchievementAdapter(
    private var list: MutableList<Achievement>,
    private val onDeleteClick: (Int) -> Unit,
    private val onEditClick: (Achievement) -> Unit
) : RecyclerView.Adapter<AchievementAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTitle)
        val description: TextView = view.findViewById(R.id.tvDescription)
        val date: TextView = view.findViewById(R.id.tvDateTag)
        val btnDelete: Button = view.findViewById(R.id.btnDelete)
        val btnEdit: Button = view.findViewById(R.id.btnEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_achievement, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.title.text = item.title
        holder.description.text = item.description
        holder.date.text = item.date

        holder.btnDelete.setOnClickListener { onDeleteClick(item.id) }
        holder.btnEdit.setOnClickListener { onEditClick(item) }
    }

    override fun getItemCount() = list.size

    // Helper to update list efficiently
    fun updateData(newList: List<Achievement>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}