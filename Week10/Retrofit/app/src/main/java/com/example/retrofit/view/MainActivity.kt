package com.example.retrofit.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.retrofit.WeatherApplication
import com.example.retrofit.data.RetrofitInstance
import com.example.retrofit.data.WeatherResponse
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.viewmodel.WeatherViewModel
import com.example.retrofit.viewmodel.WeatherViewModelFactory
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: WeatherViewModel by viewModels {
        WeatherViewModelFactory((application as WeatherApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val key: String = "5e959cfc0a094e69b6d225438250503"
        var place: String = "New York"


        binding.cityInput.addTextChangedListener { editable ->
            place = editable?.toString() ?: ""
        }

        // Listen for "Enter" key press
        binding.button.setOnClickListener{
            viewModel.fetchWeather(key, place)
        }

        // Observe weather data
        viewModel.weatherData.observe(this, Observer { weatherResponse ->
            updateUI(weatherResponse)
        })

        // Observe error messages
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            Log.e("API Error", errorMessage)
        })

        viewModel.fetchWeather(key, place)


    }



    private fun updateUI(weatherResponse: WeatherResponse) {
        val location = weatherResponse.location
        val current = weatherResponse.current

        binding.location.text = "Location: ${location.name}"
        binding.condition.text = "Condition: ${current.condition.text}"
        binding.temperature.text = "Temperature: ${current.temp_c}°C"
        binding.windSpeed.text = "Wind Speed: ${current.wind_mph} mph"
        binding.humidity.text = "Humidity: ${current.humidity}%"
    }
}