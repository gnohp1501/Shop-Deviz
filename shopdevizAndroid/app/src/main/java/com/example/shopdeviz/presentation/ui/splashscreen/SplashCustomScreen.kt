package com.example.shopdeviz.presentation.ui.splashscreen

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.SplashCustomScreenBinding
import com.example.shopdeviz.presentation.common.BaseFragment

class SplashCustomScreen :
    BaseFragment<SplashCustomScreenBinding>(SplashCustomScreenBinding::inflate) {

    val FIRST_TIME: Boolean = true
    val LOGGED: Boolean = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.beginTransaction().add(
            R.id.frlSplashScreen, SplashFragment.newInstance(onDoneSplash = {
                // Open app first time run *Introduce
                if (FIRST_TIME && !LOGGED) {
                    parentFragmentManager.beginTransaction().replace(
                        R.id.frlSplashScreen, IntroduceFragment.newInstance(onDoneIntroduce = {
                            Navigation.findNavController(view)
                                .navigate(R.id.action_splashScreen_to_authenScreen)
                        })
                    ).commit()
                } else if (!FIRST_TIME && !LOGGED) {
                    // Open app when not not logged in
                    Navigation.findNavController(view)
                        .navigate(R.id.action_splashScreen_to_authenScreen)
                } else {
                    // Open app when logged
                    Navigation.findNavController(view)
                        .navigate(R.id.action_splashScreen_to_mainScreen)
                }
            })
        ).commit()
    }

}