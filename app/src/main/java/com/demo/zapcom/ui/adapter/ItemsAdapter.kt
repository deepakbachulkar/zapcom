package com.demo.zapcom.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.zapcom.R
import com.demo.zapcom.data.model.Item
import com.demo.zapcom.data.model.SubItem
import com.demo.zapcom.data.model.Type
import com.demo.zapcom.databinding.BannerBinding
import com.demo.zapcom.databinding.HorizontalFreeScrollBinding
import com.demo.zapcom.databinding.SplitBannerBinding
import javax.inject.Inject

class ItemsAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<Item>()

    override fun getItemViewType(position: Int): Int {
        return when (items[position].sectionType) {
            Type.HORIZONTAL_FREE_SCROLL.getType() -> R.layout.horizontal_free_scroll
            Type.SPLIT_BANNER.getType() -> R.layout.split_banner
            Type.BANNER.getType() -> R.layout.banner
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.horizontal_free_scroll -> HorizontalFreeScrollViewHolder(
                HorizontalFreeScrollBinding.inflate(LayoutInflater.from(parent.context), parent, false), context = parent.context
            )
            R.layout.split_banner -> SplitBannerViewHolder(
                SplitBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false), context = parent.context
            )
            R.layout.banner -> BannerViewHolder(
                BannerBinding.inflate(LayoutInflater.from(parent.context), parent, false), context = parent.context
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HorizontalFreeScrollViewHolder -> holder.bind(items[position])
            is SplitBannerViewHolder -> holder.bind(items[position])
            is BannerViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    fun submitList(newItems: List<Item>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}