package com.example.shopdeviz.presentation.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.ItemOptionLoginBinding


class ItemOptionLogin : LinearLayout {

    private var _binding: ItemOptionLoginBinding? = null
    private val binding get() = _binding!!

    constructor(context: Context) : super(context) {
        initView()
        configUI()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
        configUI(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        initView()
        configUI(attrs)
    }

    init {
        _binding = ItemOptionLoginBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private fun initView() {
        inflate(context, R.layout.item_option_login, this)
    }

    private fun configUI(attributeSet: AttributeSet? = null) {
        val typedArray =
            context.theme.obtainStyledAttributes(attributeSet, R.styleable.ItemOptionLogin, 0, 0)
        if (typedArray.hasValue(R.styleable.ItemOptionLogin_tvOption)) {
            val tvOption = typedArray.getString(R.styleable.ItemOptionLogin_tvOption)
            binding.tvOption.text = tvOption
        }
        if (typedArray.hasValue(R.styleable.ItemOptionLogin_src)) {
            val ivOption = typedArray.getDrawable(R.styleable.ItemOptionLogin_src)
            binding.ivOption.setImageDrawable(ivOption)
        }
        typedArray.recycle()
    }
}