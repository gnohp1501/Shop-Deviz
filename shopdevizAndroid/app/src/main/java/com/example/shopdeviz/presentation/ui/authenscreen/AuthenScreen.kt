package com.example.shopdeviz.presentation.ui.authenscreen

import android.os.Bundle
import android.view.View
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.AuthenScreenBinding
import com.example.shopdeviz.presentation.common.BaseFragment

class AuthenScreen : BaseFragment<AuthenScreenBinding>(AuthenScreenBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.beginTransaction().add(
            R.id.frlAuthenScreen, ChooseAuthenFragment()
        ).commit()
    }
}