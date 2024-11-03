package com.kryptforge.stokal.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kryptforge.stokal.data.database.AppDatabase
import com.kryptforge.stokal.data.entities.Lot
import com.kryptforge.stokal.data.entities.LotType
import kotlinx.coroutines.launch

class LotTypeViewModel(application: Application) : AndroidViewModel(application) {
    private val lotTypeDao = AppDatabase.getDatabase(application).lotTypeDao()

    fun insert(lotType: LotType) {
        viewModelScope.launch {
            lotTypeDao.insert(lotType)
        }
    }

    suspend fun getAllLotType() : List<LotType> {
        return lotTypeDao.getAllLotType()
    }

    suspend fun getLotTypeById(id: Int): LotType? {
        return lotTypeDao.getById(id)
    }
}