package com.example.demo.domain

import com.example.demo.data.model.*
import com.example.demo.data.remote.ServiceDataSource

class ServiceRepositoryImpl(private val dataSource: ServiceDataSource): ServiceRepository {

    override suspend fun getServiciosMedicos(): ServiceList = dataSource.getServiciosMedicos()
    override suspend fun getPolicia(): ServiceList = dataSource.getPolicia()
    override suspend fun getRestaurantes(): ServiceList = dataSource.getRestaurantes()
    override suspend fun getGasolineras(): ServiceList = dataSource.getGasolineras()
    override suspend fun getMantenimiento(): ServiceList = dataSource.getMantenimiento()
    override suspend fun getLimpieza(): ServiceList = dataSource.getLimpieza()
    override suspend fun getVulcanizadora(): ServiceList = dataSource.getVulcanizadora()
    override suspend fun getFerreterias(): ServiceList = dataSource.getFerreterias()
}