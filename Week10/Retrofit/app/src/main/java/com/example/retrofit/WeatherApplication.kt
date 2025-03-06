package com.example.retrofit


import android.app.Application
import com.example.retrofit.data.RetrofitInstance
import com.example.retrofit.data.WeatherRepository

class WeatherApplication : Application() {

    val repository: WeatherRepository by lazy {
        WeatherRepository(RetrofitInstance.api)
    }
}