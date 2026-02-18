
package com.example.milestonemindmobile

import java.io.Serializable

data class Achievement(
    val id: Int,
    val title: String,
    val date: String,
    val description: String
) : Serializable // Allows passing this object between Activities