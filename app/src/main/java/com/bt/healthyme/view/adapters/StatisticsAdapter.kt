package com.bt.healthyme.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bt.healthyme.databinding.ItemStatisticsBinding
import com.bt.healthyme.databinding.ItemTrainingBinding
import com.bt.healthyme.model.StatisticModel
import com.bt.healthyme.model.TrainingModel

class StatisticsAdapter: RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>() {

    var items:ArrayList<StatisticModel>? = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        val binding = ItemStatisticsBinding.inflate(LayoutInflater.from(parent.context))
        return StatisticsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = items?.size ?: 0

    inner class StatisticsViewHolder(private val binding: ItemStatisticsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.age = items?.get(adapterPosition)?.age + " років"
            binding.date = items?.get(adapterPosition)?.date
            binding.weight = items?.get(adapterPosition)?.weight + " кг"
            binding.height = items?.get(adapterPosition)?.height+ " см"

            binding.executePendingBindings()
        }
    }
}