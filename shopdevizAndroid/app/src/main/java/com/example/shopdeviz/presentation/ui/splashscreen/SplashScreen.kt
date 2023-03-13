package com.example.shopdeviz.presentation.ui.splashscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.FragmentSplashBinding
import com.example.shopdeviz.presentation.common.BaseFragment
import com.example.shopdeviz.presentation.common.NavigationManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewLifecycleOwner.lifecycleScope.launch {
            delay(1000 * 2)
            NavigationManager.instance.navController?.navigate(R.id.introduceScreen)
        }

        super.onViewCreated(view, savedInstanceState)
    }

}