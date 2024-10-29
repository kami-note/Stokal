package com.kryptforge.stokal.data.dao

import androidx.room.Insert
import androidx.room.Query
import com.kryptforge.stokal.data.entities.History

interface HistoryDao {
    @Insert
    suspend fun insert(history: History)

    @Query("SELECT * FROM `history` WHERE id = :id")
    suspend fun getById(id: Int): History?
}