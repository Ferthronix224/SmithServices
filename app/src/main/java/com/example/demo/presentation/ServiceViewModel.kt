package com.example.demo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.demo.core.Resource
import com.example.demo.domain.ServiceRepository
import kotlinx.coroutines.Dispatchers

class ServiceViewModel(private val repo: ServiceRepository) : ViewModel() {

    fun fetchMainScreenMovies() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success((repo.getServiciosMedicos())))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
        try {
            emit(Resource.Success(repo.getPolicia()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
        try {
            emit(Resource.Success(repo.getRestaurantes()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
        try {
            emit(Resource.Success(repo.getGasolineras()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
        try {
            emit(Resource.Success(repo.getMantenimiento()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
        try {
            emit(Resource.Success(repo.getLimpieza()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
        try {
            emit(Resource.Success(repo.getVulcanizadora()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
        try {
            emit(Resource.Success(repo.getFerreterias()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}

class ServiceViewModelFactory(private val repo: ServiceRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ServiceRepository::class.java).newInstance(repo)
    }
}