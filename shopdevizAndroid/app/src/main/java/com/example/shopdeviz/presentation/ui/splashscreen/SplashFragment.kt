package com.example.shopdeviz.presentation.ui.splashscreen

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.shopdeviz.databinding.FragmentSplashBinding
import com.example.shopdeviz.presentation.common.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    lateinit var onDoneSplash: () -> Unit

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
            onDoneSplash.invoke()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(onDoneSplash: () -> Unit): SplashFragment {
            val fragment = SplashFragment()
            fragment.onDoneSplash = onDoneSplash
            return fragment
        }
    }

}