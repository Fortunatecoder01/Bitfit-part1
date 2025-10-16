package com.example.bitfit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit.data.FoodEntity
import com.example.bitfit.databinding.ItemFoodBinding

class FoodAdapter (private val onDeleteClick: (FoodEntity) -> Unit = {}) : ListAdapter<FoodEntity, FoodAdapter.VH>(DIFF) {
    object DIFF : DiffUtil.ItemCallback<FoodEntity>() {
        override fun areItemsTheSame(old: FoodEntity, new: FoodEntity) = old.id == new.id
        override fun areContentsTheSame(old: FoodEntity, new: FoodEntity) = old == new
    }

    inner class VH(private val b: ItemFoodBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(item: FoodEntity) {
            b.tvName.text = item.name
            b.tvCalories.text = item.calories.toString()
            b.btnDelete.setOnClickListener { onDeleteClick(item) }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val b = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return VH(b)
        }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))    }
    }