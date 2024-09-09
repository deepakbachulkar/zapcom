package com.demo.zapcom.ui.adapter

import android.content.Context
import android.renderscript.ScriptGroup.Binding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.zapcom.data.model.Item
import com.demo.zapcom.data.model.SubItem
import com.demo.zapcom.databinding.BannerBinding

class BannerViewHolder(private val binding: BannerBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item) {
        item.items.first().let {
            binding.name.text = it.title
            Glide.with(context).load(it.image).into(binding.banner)
        }
    }
}