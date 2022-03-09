package com.manimarank.wikisourceapp.ui.main

import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.manimarank.wikisourceapp.R
import com.manimarank.wikisourceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_settings
            )
        )
        // setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        setupLanguageSpinner()
    }

    private fun setupLanguageSpinner() {
        binding.run {
            val languageDataForSpinner = listOf("English", "Tamil", "BengaliMANIMMMMMMMMMMMMMMMMMMMMARAN")
            val adapter = ArrayAdapter(applicationContext, R.layout.item_language, languageDataForSpinner.toTypedArray())
            spinnerLanguage.setAdapter(adapter)
            spinnerLanguage.setText(languageDataForSpinner.firstOrNull().toString(), false)
            spinnerLanguage.setOnItemClickListener { _, _, position, _ ->

            }
        }
    }
}