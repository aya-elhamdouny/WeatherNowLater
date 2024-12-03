package com.aya.weathernowlater.domain.repository

import com.aya.weathernowlater.data.utils.ResourceState
import androidx.lifecycle.LiveData
import com.aya.weathernowlater.data.models.response.WeatherResponse
import com.aya.weathernowlater.domain.entites.MainWeather

interface WeatherRepository {

    suspend fun getCurrentWeather(countryName: String): LiveData<ResourceState<MainWeather>>
}