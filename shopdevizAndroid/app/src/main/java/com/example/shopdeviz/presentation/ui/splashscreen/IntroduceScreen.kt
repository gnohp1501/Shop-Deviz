package com.example.shopdeviz.presentation.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2
import com.example.shopdeviz.MainActivity
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.FragmentSplashStep1Binding
import com.example.shopdeviz.presentation.adapter.ViewPagerAdapter
import com.example.shopdeviz.presentation.common.BaseFragment
import com.example.shopdeviz.presentation.common.NavigationManager

class IntroduceScreen :
    BaseFragment<FragmentSplashStep1Binding>(FragmentSplashStep1Binding::inflate) {

    private var hashmap: HashMap<Int, CardView> = hashMapOf()
    private var resource = context?.resources

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hashmap = hashMapOf(0 to binding.cv1, 1 to binding.cv2, 2 to binding.cv3)
        resource = context?.resources
        binding.intro.adapter = ViewPagerAdapter()

        binding.introduceButton.setOnClickListener {
            buttonIntroduceClick()
        }

        binding.intro.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int, positionOffset: Float, positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                changeIndicator()
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeIndicator()
            }
        })

    }

    fun changeIndicator() {
        binding.introduceButton.text =
            if (binding.intro.currentItem < 2) resource?.getString(R.string.nextLabel)
            else resource?.getString(R.string.getStartedLabel)
        for (i in hashmap.keys) {
            val params = hashmap[i]?.layoutParams
            if (i == binding.intro.currentItem) {
                hashmap[i]?.setCardBackgroundColor(resource?.getColor(R.color.black) ?: 0)
                params?.width = resource?.getDimensionPixelOffset(R.dimen._30sdp)
            } else {
                hashmap[i]?.setCardBackgroundColor(resource?.getColor(R.color.silver) ?: 0)
                params?.width = resource?.getDimensionPixelOffset(R.dimen._10sdp)
            }
            hashmap[i]?.layoutParams = params
        }
    }

    private fun buttonIntroduceClick() {
        if (binding.intro.currentItem < ViewPagerAdapter().itemCount - 1) {
            binding.intro.currentItem = binding.intro.currentItem + 1
        } else {
            activity?.let {
                it.startActivity(Intent(it, MainActivity::class.java))
            }
        }
    }

}