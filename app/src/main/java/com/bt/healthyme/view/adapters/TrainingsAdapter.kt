package com.bt.healthyme.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bt.healthyme.databinding.FragmentTrainingBinding
import com.bt.healthyme.databinding.ItemTrainingBinding
import com.bt.healthyme.model.TrainingModel

class TrainingsAdapter : RecyclerView.Adapter<TrainingsAdapter.TrainingsViewHolder>() {

    var trainingItems = arrayListOf<TrainingModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingsViewHolder {
        val binding = ItemTrainingBinding.inflate(LayoutInflater.from(parent.context))
        return TrainingsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainingsViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = trainingItems.size

    inner class TrainingsViewHolder(val binding: ItemTrainingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.name = trainingItems[adapterPosition].trainingName
            binding.count = trainingItems[adapterPosition].trainingRepeats
            binding.executePendingBindings()
        }
    }
}