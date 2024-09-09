package com.demo.zapcom.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.zapcom.R
import com.demo.zapcom.data.model.SubItem
import com.demo.zapcom.databinding.ImageviewBinding
import javax.inject.Inject


class ImageAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<SubItem>()

    override fun getItemViewType(position: Int): Int {
        return R.layout.imageview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ImageviewBinding.inflate(LayoutInflater.from(parent.context), parent, false), context = parent.context)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    fun submitList(newItems: List<SubItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}