package com.kryptforge.stokal.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kryptforge.stokal.data.dao.ActionDao
import com.kryptforge.stokal.data.dao.HistoryDao
import com.kryptforge.stokal.data.dao.LabelDao
import com.kryptforge.stokal.data.dao.LotDao
import com.kryptforge.stokal.data.dao.LotTypeDao
import com.kryptforge.stokal.data.dao.NotificationDao
import com.kryptforge.stokal.data.entities.Action
import com.kryptforge.stokal.data.entities.Lot

@Database(entities = [Action::class, HistoryDao::class, LabelDao::class,Lot::class, NotificationDao::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun actionDao(): ActionDao
    abstract fun historyDao(): HistoryDao
    abstract fun labelDao(): LabelDao
    abstract fun lotDao(): LotDao
    abstract fun lotTypeDao() : LotTypeDao
    abstract fun notificationDao(): NotificationDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}