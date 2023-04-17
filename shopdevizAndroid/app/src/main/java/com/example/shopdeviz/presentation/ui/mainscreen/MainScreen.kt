package com.example.shopdeviz.presentation.ui.mainscreen

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.MainScreenBinding
import com.example.shopdeviz.presentation.common.BaseFragment
import com.example.shopdeviz.presentation.common.NavigationManager

class MainScreen : BaseFragment<MainScreenBinding>(MainScreenBinding::inflate) {
    private var navController: NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigation()

    }

    private fun initNavigation() {
        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_graph_main_screen) as? NavHostFragment
        navController = nestedNavHostFragment?.navController
        navController?.let {
            NavigationUI.setupWithNavController(binding.navigation, it)
            val navigationManager: NavigationManager = NavigationManager.instance
            navigationManager.navController = navController
        }
    }

}