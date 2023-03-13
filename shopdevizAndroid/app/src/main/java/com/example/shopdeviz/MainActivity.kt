package com.example.shopdeviz

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.shopdeviz.databinding.ActivityMainBinding
import com.example.shopdeviz.presentation.common.NavigationManager
import com.example.shopdeviz.presentation.viewmodel.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val productViewModel by viewModel<ProductViewModel>()

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initNavigation()

        productViewModel.getProduct(this, onFinish = {
            productViewModel.productLiveData.value = it
            Log.d("subscribeByResource22",productViewModel.productLiveData.value.toString())
        })
    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.navigation, navController)
        val navigationManager: NavigationManager = NavigationManager.instance
        navigationManager.navController = navController
    }
}