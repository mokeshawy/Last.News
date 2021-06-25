package com.example.lastnews.activitis


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.lastnews.R
import com.example.lastnews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding            : ActivityMainBinding
    lateinit var navHostFragment    : NavHostFragment
    lateinit var navController      : NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // operation work for navigation component.
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController   = navHostFragment.navController

        // set up for action bar on page.
        appBarConfiguration = AppBarConfiguration(setOf(R.id.welcomeFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)

        // operation work for action bar show and hide.
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.splashFragment     -> supportActionBar!!.hide()
                R.id.welcomeFragment    -> supportActionBar!!.hide()
                else -> supportActionBar!!.show()
            }
        }
        // operation work for navigationBottom show and hide.
        navController.addOnDestinationChangedListener { _, destination, _ ->

            when(destination.id){
            }
        }
    }
}