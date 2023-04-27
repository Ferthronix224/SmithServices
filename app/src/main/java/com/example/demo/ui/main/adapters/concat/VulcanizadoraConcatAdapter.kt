package com.example.demo.ui.main.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.core.BaseConcatHolder
import com.example.demo.databinding.LimpiezaRowBinding
import com.example.demo.databinding.MantenimientoRowBinding
import com.example.demo.databinding.MedicosServiceRowBinding
import com.example.demo.databinding.VulcanizadoraRowBinding
import com.example.demo.ui.main.adapters.ServiceAdapter

class VulcanizadoraConcatAdapter(private val serviceAdapter: ServiceAdapter): RecyclerView.Adapter<BaseConcatHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = VulcanizadoraRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when (holder) {
            is ConcatViewHolder -> holder.bind(serviceAdapter)
            else -> throw IllegalArgumentException("No viewholder to show this data, did you forgot to add it to the onBindViewHolder?")
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: VulcanizadoraRowBinding) : BaseConcatHolder<ServiceAdapter>(binding.root) {
        override fun bind(adapter: ServiceAdapter) {
            binding.rvVulcanizadora.adapter = adapter
        }
    }
}