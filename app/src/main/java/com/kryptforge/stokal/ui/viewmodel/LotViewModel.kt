package com.kryptforge.stokal.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kryptforge.stokal.data.database.AppDatabase
import com.kryptforge.stokal.data.entities.Lot
import kotlinx.coroutines.launch

class LotViewModel(application: Application) : AndroidViewModel(application) {
    private val lotDao = AppDatabase.getDatabase(application).lotDao()

    fun inset(lot: Lot){
        viewModelScope.launch {
            lotDao.insert(lot)
        }
    }

    suspend fun getLotById(id: Int): Lot? {
        return lotDao.getById(id)
    }
}