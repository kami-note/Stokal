package com.kryptforge.stokal.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kryptforge.stokal.data.database.AppDatabase
import com.kryptforge.stokal.data.entities.Notification
import kotlinx.coroutines.launch

class NotificationViewModel(application: Application) : AndroidViewModel(application) {
    private val notificationDao = AppDatabase.getDatabase(application).notificationDao()

    fun insert(notification: Notification){
        viewModelScope.launch {
            notificationDao.insert(notification)
        }
    }

    suspend fun getNotificationById(id: Int): Notification? {
        return notificationDao.getById(id)
    }
}