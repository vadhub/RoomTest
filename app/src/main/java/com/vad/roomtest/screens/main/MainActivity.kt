package com.vad.roomtest.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.vad.roomtest.R
import com.vad.roomtest.screens.listusersfragment.UsersFragment
import com.vad.roomtest.screens.listworksfragment.WorksFragment

class MainActivity : AppCompatActivity() {

    private lateinit var currentFragment: Fragment
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavView = findViewById(R.id.menu_nav)
        currentFragment = UsersFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, currentFragment).commit()
        bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navUsers -> currentFragment = UsersFragment()
                R.id.navWorks -> currentFragment = WorksFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, currentFragment).commit()
            return@setOnNavigationItemSelectedListener true
        }
    }
}