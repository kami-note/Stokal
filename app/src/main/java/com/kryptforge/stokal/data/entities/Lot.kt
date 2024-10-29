package com.kryptforge.stokal.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lot")
data class Lot(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val itemCount: Int,
    val expirationDate: Long,
    val lotType: String,
    val status: String,
    val validationDate: Long?,
    val notes: String?,
    val estimatedValue: Double?,
    val lotTypeId: Int?,
    val labelId: Int?
)
