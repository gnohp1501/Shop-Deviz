package com.example.edeviz.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null

    val binding: VB
        get() = _binding as VB

    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB

    open fun initView() {}

    open fun obverseData() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflateLayout(layoutInflater)
        initView()
        obverseData()
        setContentView(binding.root)
    }

}