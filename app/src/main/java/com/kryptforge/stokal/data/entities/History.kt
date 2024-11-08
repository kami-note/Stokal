package com.kryptforge.stokal.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val lotId: Int?,
    val dataAction: Long,
    val actionId: Int?
)
