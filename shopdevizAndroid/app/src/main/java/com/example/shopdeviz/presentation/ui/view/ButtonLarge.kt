package com.example.shopdeviz.presentation.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.ButtonLargeBinding


class ButtonLarge : LinearLayout {
    private var _binding: ButtonLargeBinding? = null
    private val binding get() = _binding!!

    private var callback: IButtonLargeCallback? = null

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
        _binding = ButtonLargeBinding.inflate(LayoutInflater.from(context), this, true)
        binding.llButtonLarge.setOnClickListener {
            callback?.onClick()
        }
    }

    fun onClick(listener: IButtonLargeCallback) {
        callback = listener
    }

    private fun initView() {
        inflate(context, R.layout.button_large, this)
    }

    private fun configUI(attributeSet: AttributeSet? = null) {
        val typedArray =
            context.theme.obtainStyledAttributes(attributeSet, R.styleable.ButtonLarge, 0, 0)
        if (typedArray.hasValue(R.styleable.ButtonLarge_tvButton)) {
            val tvButton = typedArray.getString(R.styleable.ButtonLarge_tvButton)
            binding.tvButton.text = tvButton
        }
        typedArray.recycle()
    }

}

interface IButtonLargeCallback {
    fun onClick()
}