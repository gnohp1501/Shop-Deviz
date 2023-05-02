package com.example.shopdeviz.presentation.ui.splashscreen

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2
import com.example.shopdeviz.R
import com.example.shopdeviz.databinding.IntroduceFragmentBinding
import com.example.shopdeviz.presentation.adapter.ViewPagerAdapter
import com.example.shopdeviz.presentation.common.BaseFragment
import com.example.shopdeviz.presentation.ui.view.IButtonLargeCallback

class IntroduceFragment :
    BaseFragment<IntroduceFragmentBinding>(IntroduceFragmentBinding::inflate) {

    private var hashmap: HashMap<Int, CardView> = hashMapOf()
    private var resource = context?.resources

    lateinit var onDoneIntroduce: () -> Unit

    companion object {
        fun newInstance(onDoneIntroduce: () -> Unit): IntroduceFragment {
            val fragment = IntroduceFragment()
            fragment.onDoneIntroduce = onDoneIntroduce
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hashmap = hashMapOf(0 to binding.cv1, 1 to binding.cv2, 2 to binding.cv3)
        resource = context?.resources
        binding.intro.adapter = ViewPagerAdapter()

        binding.nextButton.onClick(
            object : IButtonLargeCallback {
                override fun onClick() {
                    Log.d("123123:13", "Asdsadsad")
                }
            }
        )

        binding.getStartedButton.setOnClickListener { buttonGetStartedClick() }

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

    private fun buttonNextClick() {
        binding.intro.currentItem = binding.intro.currentItem + 1
        if (binding.intro.currentItem == 2) {
            binding.nextButton.visibility = View.GONE
            binding.getStartedButton.visibility = View.VISIBLE
        }
    }

    private fun buttonGetStartedClick() {
        onDoneIntroduce.invoke()
    }

}