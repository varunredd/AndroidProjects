package com.example.retrofit.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.http.Query
import java.io.IOException

class WeatherRepository(private val api: WeatherApi) {

    suspend fun getWeather(@Query("key") key: String, @Query("q") q:String): Response<WeatherResponse> {
        return withContext(Dispatchers.IO) {
            try {
                api.getWeather(key,q)
            } catch (e: IOException) {
                throw e
            } catch (e: HttpException) {
                throw e
            }
        }
    }
}