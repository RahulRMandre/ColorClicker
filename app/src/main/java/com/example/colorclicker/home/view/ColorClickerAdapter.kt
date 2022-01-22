package com.example.colorclicker.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.colorclicker.databinding.ColorClickerListItemBinding
import com.example.colorclicker.home.viewmodel.ColorClickerViewModel

class ColorClickerAdapter(private val viewModel: ColorClickerViewModel) :
    RecyclerView.Adapter<ColorClickerAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ColorClickerListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: ColorClickerViewModel, position: Int) {
            binding.viewModel = viewModel
            binding.position = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ColorClickerListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel, position)
    }

    override fun getItemCount() = viewModel.numberList.value?.size ?: 0
}