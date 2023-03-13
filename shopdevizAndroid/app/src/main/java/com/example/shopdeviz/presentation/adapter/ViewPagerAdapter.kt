package com.example.shopdeviz.presentation.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopdeviz.databinding.ItemIntroduceBinding
import com.example.shopdeviz.presentation.common.Introduce

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerAdapterViewHolder>() {

    private var listIntro = Introduce.values()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapterViewHolder {
        return ViewPagerAdapterViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapterViewHolder, position: Int) {
        var itemData = listIntro[position]
        holder.bind(itemData, position)
    }

    override fun getItemCount() = listIntro.size

    class ViewPagerAdapterViewHolder(var binding: ItemIntroduceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun create(parent: ViewGroup): ViewPagerAdapterViewHolder {
                val itemIntroduceBinding = ItemIntroduceBinding.inflate(
                    (parent.context as Activity).layoutInflater, parent, false
                )
                return ViewPagerAdapterViewHolder(itemIntroduceBinding)
            }
        }

        fun bind(intro: Introduce, position: Int) {
            binding.apply {
                textIntro.text = intro.title
                Glide.with(binding.root).load(intro.image).into(imageIntro)
            }
        }
    }

}