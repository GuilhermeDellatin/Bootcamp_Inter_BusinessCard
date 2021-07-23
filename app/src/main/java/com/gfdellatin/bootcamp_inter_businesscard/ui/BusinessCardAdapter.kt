package com.gfdellatin.bootcamp_inter_businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gfdellatin.bootcamp_inter_businesscard.data.BusinessCard
import com.gfdellatin.bootcamp_inter_businesscard.databinding.ItemBusinessCardBinding


class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BusinessCard) {
            binding.tvName.text = item.name
            binding.tvPhone.text = item.phone
            binding.tvMail.text = item.email
            binding.tvEnterprise.text = item.enterprise
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.colorPersonalization))

            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }

            binding.btnDelete.setOnClickListener {
                listenerDelete(item)
            }

        }
    }

    var listenerShare: (View) -> Unit = {}
    var listenerDelete: (BusinessCard) -> Unit = {}

}

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}

