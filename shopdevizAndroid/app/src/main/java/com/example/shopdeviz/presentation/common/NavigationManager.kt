package com.example.shopdeviz.presentation.common

import androidx.navigation.NavController

class NavigationManager private constructor() {
    var navController: NavController? = null

    companion object {
        val instance = NavigationManager()
    }
}