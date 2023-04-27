package com.example.demo.ui.main.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.core.BaseConcatHolder
import com.example.demo.databinding.GasolinerasRowBinding
import com.example.demo.ui.main.adapters.ServiceAdapter

class GasolinerasConcatAdapter(private val serviceAdapter: ServiceAdapter): RecyclerView.Adapter<BaseConcatHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = GasolinerasRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when (holder) {
            is ConcatViewHolder -> holder.bind(serviceAdapter)
            else -> throw IllegalArgumentException("No viewholder to show this data, did you forgot to add it to the onBindViewHolder?")
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: GasolinerasRowBinding) : BaseConcatHolder<ServiceAdapter>(binding.root) {
        override fun bind(adapter: ServiceAdapter) {
            binding.rvGasolineras.adapter = adapter
        }
    }
}