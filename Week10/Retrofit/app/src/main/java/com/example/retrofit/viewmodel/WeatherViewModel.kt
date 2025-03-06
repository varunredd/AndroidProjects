package com.example.retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.WeatherRepository
import com.example.retrofit.data.WeatherResponse
import kotlinx.coroutines.launch

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> get() = _weatherData

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun fetchWeather(key: String, place: String){
        viewModelScope.launch {
            try {
                val response = weatherRepository.getWeather(key,place)
                if(response.isSuccessful && response.body() != null){
                    _weatherData.value = response.body()!!
                }else{
                    _errorMessage.value = "Failed to Fetch Weather Data"
                }
            }catch (e : Exception){
                _errorMessage.value = e.message ?: "An Error Occurred"
            }
        }
    }
}