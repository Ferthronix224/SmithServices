package com.example.demo.data.remote

import com.example.demo.data.model.*
import com.example.demo.domain.WebService

class ServiceDataSource(private val webService: WebService) {

    suspend fun getServiciosMedicos(): ServiceList {
        return webService.getServiciosMedicos()
    }

    suspend fun getPolicia(): ServiceList {
        return webService.getPolicia()
    }

    suspend fun getRestaurantes(): ServiceList {
        return webService.getRestaurantes()
    }

    suspend fun getGasolineras(): ServiceList {
        return webService.getGasolineras()
    }

    suspend fun getMantenimiento(): ServiceList {
        return webService.getMantenimiento()
    }

    suspend fun getLimpieza(): ServiceList {
        return webService.getLimpieza()
    }

    suspend fun getVulcanizadora(): ServiceList {
        return webService.getVulcanizadora()
    }

    suspend fun getFerreterias(): ServiceList {
        return webService.getFerreterias()
    }
}