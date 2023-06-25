package com.example.edeviz.feature.home

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import com.example.edeviz.base.BaseFragment
import com.example.edeviz.feature.login.LoginViewModel
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, LoginViewModel>() {

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentHomeBinding.inflate(layoutInflater)

    override val mViewModel: LoginViewModel by viewModels()

    override fun initView() {
        super.initView()
        with(binding) {
            tvEdit.text = "123"
        }
    }
}