package com.secondslot.thecatsapi.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.secondslot.thecatsapi.R
import com.secondslot.thecatsapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        // Initialize navController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.container) as NavHostFragment
        val navController = navHostFragment.navController

        // Hook up navigation button (up/drawer) on toolbar
        val appBarConfiguration = AppBarConfiguration(navController.graph, null)

        // To hook up navigation button we can add this setting
        // and then button "back" will work automatically
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}
