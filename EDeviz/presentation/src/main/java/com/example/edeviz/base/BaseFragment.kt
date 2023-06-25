package com.example.edeviz.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    open var useSharedViewModel: Boolean = false

    private var _binding: VB? = null

    val binding: VB
        get() = _binding as VB

    protected abstract val mViewModel: VM

    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB

    open fun initView() {}

    open fun obverseData() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateLayout(inflater)
        if (_binding == null) throw IllegalArgumentException("Binding null")
        initView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        obverseData()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}