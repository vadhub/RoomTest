package com.vad.roomtest.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vad.roomtest.room.dao.DaoUsers
import com.vad.roomtest.room.dao.DaoWorks
import com.vad.roomtest.room.dao.User
import com.vad.roomtest.room.dao.Work

@Database(entities = [
    User::class, Work::class
], version = 1, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {
    abstract fun daoUsers(): DaoUsers
    abstract fun daoWorks(): DaoWorks

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database.db"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}