package com.kryptforge.stokal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kryptforge.stokal.data.entities.Lot

@Dao
interface LotDao {
    @Insert
    suspend fun insert(lot: Lot)

    @Query("SELECT * FROM `lot` WHERE id = :id")
    suspend fun getById(id: Int): Lot?
}