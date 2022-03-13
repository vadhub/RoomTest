package com.vad.roomtest

import android.app.Application
import android.content.Context
import androidx.room.DatabaseView
import androidx.room.Room
import com.vad.roomtest.room.dao.DaoWorks
import com.vad.roomtest.room.database.AppDatabase

class App: Application() {

    val database by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "works.db").build()
    }
    val daoWorks by lazy {
        database.daoWorks()
    }

    companion object {
        val instance by lazy {
            App()
        }
    }

}