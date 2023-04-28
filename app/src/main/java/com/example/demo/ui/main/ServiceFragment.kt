package com.example.demo.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.demo.R
import com.example.demo.core.Resource
import com.example.demo.data.model.Service
import com.example.demo.data.remote.ServiceDataSource
import com.example.demo.databinding.FragmentServiceBinding
import com.example.demo.domain.ServiceRepositoryImpl
import com.example.demo.domain.RetrofitClient
import com.example.demo.presentation.ServiceViewModel
import com.example.demo.presentation.ServiceViewModelFactory
import com.example.demo.ui.main.adapters.ServiceAdapter
import com.example.demo.ui.main.adapters.concat.*


class ServiceFragment : Fragment(R.layout.fragment_service), ServiceAdapter.OnServiceClickListener {

    private lateinit var concatAdapter: ConcatAdapter
    private lateinit var binding: FragmentServiceBinding
    private val viewModel by viewModels<ServiceViewModel> { ServiceViewModelFactory(ServiceRepositoryImpl(ServiceDataSource(RetrofitClient.webservice))) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentServiceBinding.bind(view)

        concatAdapter = ConcatAdapter()

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(0, ServiciosMedicosConcatAdapter(ServiceAdapter(it.data.first.results,this@ServiceFragment)))
                        addAdapter(1, PoliciaConcatAdapter(ServiceAdapter(it.data.second.results,this@ServiceFragment)))
                        addAdapter(2, RestaurantesConcatAdapter(ServiceAdapter(it.data.third.results,this@ServiceFragment)))
                        addAdapter(3, GasolinerasConcatAdapter(ServiceAdapter(it.data.fourth.results,this@ServiceFragment)))
                        addAdapter(4, MantenimientoConcatAdapter(ServiceAdapter(it.data.fifth.results,this@ServiceFragment)))
                        addAdapter(5, LimpiezaConcatAdapter(ServiceAdapter(it.data.sixth.results,this@ServiceFragment)))
                        addAdapter(6, VulcanizadoraConcatAdapter(ServiceAdapter(it.data.seventh.results,this@ServiceFragment)))
                        addAdapter(7, FerreteriasConcatAdapter(ServiceAdapter(it.data.eighth.results,this@ServiceFragment)))

                    }
                    binding.rvServices.adapter = concatAdapter
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.e("FetchError", "Error: $it.exception ")
                    Toast.makeText(requireContext(), "Error: ${it.exception}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    override fun onServiceClick(service: Service) {
        val action = ServiceFragmentDirections.actionServiceFragmentToServiceDetailFragment(service.poster_path, service.backdrop_path, service.address, service.number, service.ciudad, service.CreatedDate, service.name)
        findNavController().navigate(action)
    }
}