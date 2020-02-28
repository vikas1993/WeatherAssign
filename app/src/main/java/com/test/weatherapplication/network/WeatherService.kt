package com.test.weatherapplication.network

import com.test.weatherapplication.network.response.WeatherHourlyResponse
import com.test.weatherapplication.network.response.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by vikas on 29-02-2020.
 */
interface WeatherService {

    @GET("/data/2.5/weather")
    fun getWeather(@Query("q") id: String, @Query("appid") appId: String): Call<WeatherResponse>

    @GET("/data/2.5/forecast")
    fun getHourlyWeather(@Query("q") id: String, @Query("appid") appId: String): Call<WeatherHourlyResponse>
}