package com.vad.roomtest.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.vad.roomtest.R
import com.vad.roomtest.screens.listusersfragment.ListUsersFragment
import com.vad.roomtest.screens.listworksfragment.ListWorksFragment

class MainActivity : AppCompatActivity() {

    private lateinit var currentFragment: Fragment
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavView = findViewById(R.id.menu_nav)
        currentFragment = ListUsersFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, currentFragment).commit()
        bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navUsers -> currentFragment = ListUsersFragment()
                R.id.navWorks -> currentFragment = ListWorksFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, currentFragment).commit()
            return@setOnNavigationItemSelectedListener true
        }
    }
}