package com.vad.roomtest.room.database

import androidx.room.Database
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
}