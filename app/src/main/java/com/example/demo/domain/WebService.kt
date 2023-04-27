package com.example.demo.domain

import com.example.demo.application.AppConstants
import com.example.demo.data.model.*
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {
    @GET("servicios-medicos.json")
    suspend fun getServiciosMedicos(): ServiceList

    @GET("policia.json")
    suspend fun getPolicia(): ServiceList

    @GET("restaurantes.json")
    suspend fun getRestaurantes(): ServiceList

    @GET("gasolineras.json")
    suspend fun getGasolineras(): ServiceList

    @GET("mantenimiento.json")
    suspend fun getMantenimiento(): ServiceList

    @GET("limpieza.json")
    suspend fun getLimpieza(): ServiceList

    @GET("vulcanizadoras.json")
    suspend fun getVulcanizadora(): ServiceList

    @GET("ferreterias.json")
    suspend fun getFerreterias(): ServiceList
}

object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }

}