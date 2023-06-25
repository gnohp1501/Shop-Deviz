package com.example.edeviz

import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.edeviz.base.BaseActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController
    override fun inflateLayout(layoutInflater: LayoutInflater) =
        ActivityMainBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        initNavigation()
    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // SET UP START DESTINATION

        val graph = navHostFragment.navController.navInflater.inflate(R.navigation.nav_main)
        graph.setStartDestination(if (1 == 2) R.id.fragmentLogin else R.id.homeFragment)
        navHostFragment.navController.graph = graph
    }
}