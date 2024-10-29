package com.kryptforge.stokal.data.dao

import androidx.room.Insert
import androidx.room.Query
import com.kryptforge.stokal.data.entities.Label

interface LabelDao {
    @Insert
    suspend fun insert(label: Label)

    @Query("SELECT * FROM `label` WHERE id = :id")
    suspend fun getById(id: Int): Label?
}