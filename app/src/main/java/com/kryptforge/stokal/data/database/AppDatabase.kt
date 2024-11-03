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
import com.kryptforge.stokal.data.entities.History
import com.kryptforge.stokal.data.entities.Label
import com.kryptforge.stokal.data.entities.Lot
import com.kryptforge.stokal.data.entities.LotType
import com.kryptforge.stokal.data.entities.Notification

@Database(
    entities = [
        Action::class,
        History::class,
        Label::class,
        Lot::class,
        LotType::class,
        Notification::class],
    version = 2 ,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun actionDao(): ActionDao
    abstract fun historyDao(): HistoryDao
    abstract fun labelDao(): LabelDao
    abstract fun lotDao(): LotDao
    abstract fun lotTypeDao(): LotTypeDao
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
                )
                    .fallbackToDestructiveMigration() // Remover quando for para produção
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
