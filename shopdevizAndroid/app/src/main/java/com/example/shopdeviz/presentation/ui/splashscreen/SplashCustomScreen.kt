package com.example.shopdeviz.presentation.ui.splashscreen

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.SplashCustomScreenBinding
import com.example.shopdeviz.presentation.common.BaseFragment

class SplashCustomScreen :
    BaseFragment<SplashCustomScreenBinding>(SplashCustomScreenBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.beginTransaction().add(
            R.id.frlSplashScreen, SplashFragment.newInstance(onDoneSplash = {
                if (1 == 2) {
                    Navigation.findNavController(view)
                        .navigate(R.id.action_splashScreen_to_authenScreen)
                } else {
                    parentFragmentManager.beginTransaction().replace(
                        R.id.frlSplashScreen, IntroduceFragment.newInstance(onDoneIntroduce = {
                            Navigation.findNavController(view)
                                .navigate(R.id.action_splashScreen_to_mainScreen)
                        })
                    ).commit()
                }
            })
        ).commit()
    }

}