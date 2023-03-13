package com.example.shopdeviz.presentation.ui.splashscreen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.ActivitySplashBinding
import com.example.shopdeviz.presentation.common.NavigationManager


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initNavigation()

    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_splash) as NavHostFragment
        navController = navHostFragment.navController
        val navigationManager: NavigationManager = NavigationManager.instance
        navigationManager.navController = navController

    }
}