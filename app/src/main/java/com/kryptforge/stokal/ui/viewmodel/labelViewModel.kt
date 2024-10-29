package com.kryptforge.stokal.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kryptforge.stokal.data.database.AppDatabase
import com.kryptforge.stokal.data.entities.Label
import kotlinx.coroutines.launch

class labelViewModel(application: Application) : AndroidViewModel(application) {
    private val labelDao = AppDatabase.getDatabase(application).labelDao()

    fun insert(label : Label) {
        viewModelScope.launch {
            labelDao.insert(label)
        }
    }

    suspend fun getLabelById(id: Int) : Label? {
        return labelDao.getById(id)
    }
}