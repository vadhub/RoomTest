package com.vad.roomtest.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

import com.vad.roomtest.R
import com.vad.roomtest.room.database.AppDatabase

class MainActivity : AppCompatActivity() {

    val database: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "works.db")
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}