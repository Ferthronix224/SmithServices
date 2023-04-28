package com.example.demo.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo.core.BaseViewHolder
import com.example.demo.data.model.Service
import com.example.demo.databinding.ServiceItemBinding

class ServiceAdapter(
    private val servicesList: List<Service>,
    private val itemClickListener: OnServiceClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnServiceClickListener {
        fun onServiceClick(service: Service)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ServiceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ServicesViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onServiceClick(servicesList[position])
        }

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is ServicesViewHolder -> holder.bind(servicesList[position])
        }
    }

    override fun getItemCount(): Int = servicesList.size

    private inner class ServicesViewHolder(
        val binding: ServiceItemBinding,
        val context: Context
    ) : BaseViewHolder<Service>(binding.root) {
        override fun bind(item: Service) {
            Glide.with(context).load(item.poster_path).centerCrop().into(binding.imgService)
        }
    }
}