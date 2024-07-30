package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val menuOptions: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(menuOptions)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add_recipe -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container, AddRecipeFragment())
                    addToBackStack(null)
                    commit()
                }
            }
            R.id.menu_rate_app -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container, RateAppFragment())
                    addToBackStack(null)
                    commit()
                }
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}

