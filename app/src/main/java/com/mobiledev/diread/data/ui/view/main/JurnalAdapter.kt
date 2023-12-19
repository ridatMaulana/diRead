package com.mobiledev.diread.data.ui.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class JurnalAdapter(private val onItemClick:(balbal)->Unit):ListAdapter<bablbal,JurnalAdapter.MyHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemJurnalBinding.inflate(inflater, parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val items = getItem(position)
        holder.bind(items)

    }

    class MyHolder(val binding: ItemJurnalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemsItem) {
            binding.clickableText.text = item.login
            binding.textViewJournalAbstract.text=item.description
            Glide.with(binding.imageViewJournalThumbnail.context)
                .load(item.gambar)
                .into(binding.imageViewJournalThumbnail)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ItemsItem>() {
            override fun areItemsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int, payloads: MutableList<Any>) {
        val items = getItem(position)
        holder.bind(items)
        holder.itemView.setOnClickListener {
            onItemClick.invoke(items)
        }
    }
}