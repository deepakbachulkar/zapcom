package com.demo.zapcom.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.zapcom.data.model.Item
import com.demo.zapcom.data.model.SubItem
import com.demo.zapcom.databinding.SplitBannerBinding

class SplitBannerViewHolder(private val binding: SplitBannerBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item) {
        binding.recyclerView.layoutManager = GridLayoutManager(context,  2)
        val adapter = ImageAdapter()
        adapter.submitList(item.items)
        binding.recyclerView.adapter = adapter
    }
}