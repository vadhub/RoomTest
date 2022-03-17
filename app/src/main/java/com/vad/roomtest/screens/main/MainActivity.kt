package com.vad.roomtest.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.vad.roomtest.R
import com.vad.roomtest.screens.listworksfragment.ListWorksFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ListWorksFragment()).commit()
    }
}