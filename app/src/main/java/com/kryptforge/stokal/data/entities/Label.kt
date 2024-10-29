package com.kryptforge.stokal.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "label")
data class Label(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String?,
    val description: String?
)
