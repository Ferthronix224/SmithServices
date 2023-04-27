package com.example.demo.domain

import com.example.demo.data.model.*

interface ServiceRepository {
    suspend fun getServiciosMedicos(): ServiceList
    suspend fun getPolicia(): ServiceList
    suspend fun getRestaurantes(): ServiceList
    suspend fun getGasolineras(): ServiceList
    suspend fun getMantenimiento(): ServiceList
    suspend fun getLimpieza(): ServiceList
    suspend fun getVulcanizadora(): ServiceList
    suspend fun getFerreterias(): ServiceList
}