package com.kryptforge.stokal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kryptforge.stokal.data.entities.Action

@Dao
interface ActionDao {
    @Insert
    suspend fun insert(action: Action)

    @Query("SELECT * FROM `action` WHERE id = :id")
    suspend fun getById(id: Int): Action?

    @Query("SELECT * FROM `action`")
    suspend fun getAllActions() : List<Action>?
}
