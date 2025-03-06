package com.example.retrofit.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("current.json")
    suspend fun getWeather(@Query("key") key: String, @Query("q") q:String): Response<WeatherResponse>
}