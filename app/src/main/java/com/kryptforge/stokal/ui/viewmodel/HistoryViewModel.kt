package com.kryptforge.stokal.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kryptforge.stokal.data.database.AppDatabase
import com.kryptforge.stokal.data.entities.History
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    private val historyDao = AppDatabase.getDatabase(application).historyDao()

    fun insert(history: History){
        viewModelScope.launch {
            historyDao.insert(history)
        }
    }

    suspend fun getHistoryById(id: Int): History? {
        return historyDao.getById(id)
    }
}