package com.aya.weathernowlater.data.source.remote

import com.aya.weathernowlater.data.models.response.WeatherResponse

interface WeatherRemoteSource {
    suspend fun getWeatherFeed(countryName: String): WeatherResponse
}
