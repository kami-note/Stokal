package com.kryptforge.stokal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kryptforge.stokal.data.entities.Label

@Dao
interface LabelDao {
    @Insert
    suspend fun insert(label: Label)

    @Query("SELECT * FROM `label`")
    suspend fun getAll() : List<Label>?

    @Query("SELECT * FROM `label` WHERE id = :id")
    suspend fun getById(id: Int): Label?
}