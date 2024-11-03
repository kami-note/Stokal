package com.kryptforge.stokal.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kryptforge.stokal.data.database.AppDatabase
import com.kryptforge.stokal.data.entities.Label
import kotlinx.coroutines.launch

class LabelViewModel(application: Application) : AndroidViewModel(application) {
    private val labelDao = AppDatabase.getDatabase(application).labelDao()

    fun insert(label: Label) {
        if (!label.name.isNullOrEmpty()){
            viewModelScope.launch {
                labelDao.insert(label)
            }
        }
    }

    suspend fun getAllLabels(): List<Label>? {
        return labelDao.getAll()
    }

    suspend fun getLabelById(id: Int): Label? {
        return labelDao.getById(id)
    }
}