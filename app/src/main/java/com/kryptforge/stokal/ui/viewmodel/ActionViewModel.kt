package com.kryptforge.stokal.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kryptforge.stokal.data.database.AppDatabase
import com.kryptforge.stokal.data.entities.Action
import kotlinx.coroutines.launch

class ActionViewModel(application: Application) : AndroidViewModel(application) {
    private val actionDao = AppDatabase.getDatabase(application).actionDao()

    fun insert(action: Action) {
        viewModelScope.launch {
            actionDao.insert(action)
        }
    }

    suspend fun getActionById(id: Int): Action? {
        return actionDao.getById(id)
    }
}