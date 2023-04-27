package com.example.demo.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.demo.R
import com.example.demo.databinding.FragmentServiceDetailBinding

class ServiceDetailFragment : Fragment(R.layout.fragment_service_detail) {

    private val args by navArgs<ServiceDetailFragmentArgs>()
    private lateinit var binding: FragmentServiceDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentServiceDetailBinding.bind(view)
        Glide.with(requireContext()).load("${args.posterImageUrl}").centerCrop().into(binding.imgService)
        Glide.with(requireContext()).load("${args.backgroundImageUrl}").centerCrop().into(binding.imgBackground)
        binding.txtName.text = args.name
        binding.txtAddress.text = args.address
        binding.txtNumber.text = args.number
        binding.txtCiudad.text = "Ciudad: ${args.ciudad}"
        binding.txtReleased.text = "Released ${args.createdDate}"
    }
}