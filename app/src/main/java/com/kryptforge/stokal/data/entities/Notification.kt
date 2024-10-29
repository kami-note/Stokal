package com.kryptforge.stokal.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notification")
data class Notification(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val lotId: Int?,
    val message: String?,
    val dataNotification: Long,
    val viewed: Boolean?
)
