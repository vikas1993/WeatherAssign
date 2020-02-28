package com.test.weatherapplication.network.response.modal

import com.google.gson.annotations.SerializedName


data class Coord(

        @field:SerializedName("lon")
        val lon: Double? = null,

        @field:SerializedName("lat")
        val lat: Double? = null
)