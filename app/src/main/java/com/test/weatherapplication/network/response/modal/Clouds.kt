package com.test.weatherapplication.network.response.modal

import com.google.gson.annotations.SerializedName

data class Clouds(

	@field:SerializedName("all")
	val all: Int? = null
)