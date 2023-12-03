package com.mobiledev.diread.data.ui.view.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobiledev.diread.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dummyGenres = listOf("Action", "Romance", "Mystery", "Science Fiction", "Fantasy")

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        for ((index, genre) in dummyGenres.withIndex()) {
            val menuItem = bottomNavigationView.menu.add(Menu.NONE, index, Menu.NONE, genre)

        }
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                0 -> {
                    true
                }
                1 -> {
                    true
                }
                else -> false
            }
        }
    }
}