package com.example.edeviz.feature.login

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import com.example.edeviz.base.BaseFragment
import com.example.myapplication.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentLoginBinding.inflate(layoutInflater)

    override val mViewModel: LoginViewModel by viewModels()

    override fun initView() {
        super.initView()
        with(binding) {
            tvEdit.text = "123"
        }
    }

    override fun obverseData() {
        super.obverseData()
        mViewModel.test.observe(this) {
            binding.tvEdit.text = it
        }
    }
}