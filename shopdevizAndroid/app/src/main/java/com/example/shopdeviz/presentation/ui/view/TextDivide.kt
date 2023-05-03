package com.example.shopdeviz.presentation.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.ButtonLargeBinding
import com.example.shopdeviz.databinding.TextDivideBinding


class TextDivide : LinearLayout {
    private var _binding: TextDivideBinding? = null
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
        _binding = TextDivideBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private fun initView() {
        inflate(context, R.layout.text_divide, this)
    }

    private fun configUI(attributeSet: AttributeSet? = null) {
        val typedArray =
            context.theme.obtainStyledAttributes(attributeSet, R.styleable.TextDivide, 0, 0)
        if (typedArray.hasValue(R.styleable.TextDivide_tvTextDivide)) {
            val tvButton = typedArray.getString(R.styleable.TextDivide_tvTextDivide)
            binding.tvTextDivide.text = tvButton
        }
        typedArray.recycle()
    }

}
