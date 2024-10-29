package com.kryptforge.stokal.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lottype")
data class LotType(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String?,
    val description: String
)