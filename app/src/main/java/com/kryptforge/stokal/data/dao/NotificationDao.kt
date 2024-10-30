package com.kryptforge.stokal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kryptforge.stokal.data.entities.Notification

@Dao
interface NotificationDao {
    @Insert
    suspend fun insert(notification: Notification)

    @Query("SELECT * FROM `notification` WHERE id = :id")
    suspend fun getById(id: Int): Notification?
}