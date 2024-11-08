package com.kryptforge.stokal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kryptforge.stokal.data.entities.LotType

@Dao
interface LotTypeDao {
    @Insert
    suspend fun insert(lotType: LotType)

    @Query("SELECT * FROM `lottype`")
    suspend fun getAllLotType() : List<LotType>

    @Query("SELECT * FROM `lottype` WHERE id = :id")
    suspend fun getById(id: Int) : LotType?
}