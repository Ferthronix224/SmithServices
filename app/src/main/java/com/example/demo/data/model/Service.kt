package com.example.demo.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Service(
    val id: Int = -1,
    val name: String = "",
    val ciudad: String = "",
    val number: String = "",
    val address: String = "",
    val isDeleted: Int = 0,
    val CreatedBy: String = "",
    val CreatedDate: String = "",
    val UpdatedBy: String = "",
    val UpdateDate: String = "",
    val backdrop_path: String = "",
    val poster_path: String = ""
): Parcelable

data class ServiceList(val results: List<Service> = listOf())