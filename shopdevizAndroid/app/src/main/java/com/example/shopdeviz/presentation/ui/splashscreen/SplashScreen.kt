package com.example.shopdeviz.presentation.ui.splashscreen

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.SplashScreenBinding
import com.example.shopdeviz.presentation.common.BaseFragment
import com.example.shopdeviz.presentation.common.NavigationManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseFragment<SplashScreenBinding>(SplashScreenBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val scaleDownX = ObjectAnimator.ofFloat(binding.logo, "scaleX", 0.7f)
        val scaleDownY = ObjectAnimator.ofFloat(binding.logo, "scaleY", 0.7f)
        scaleDownX.duration = 1000
        scaleDownY.duration = 1000
        val scaleDown = AnimatorSet()
        scaleDown.play(scaleDownX).with(scaleDownY)
        scaleDown.start()

        viewLifecycleOwner.lifecycleScope.launch {
            delay(1000)
            binding.progressBar.visibility = View.VISIBLE
            delay(1000)
            NavigationManager.instance.navController?.navigate(R.id.introduceScreen)
        }

        super.onViewCreated(view, savedInstanceState)
    }

}