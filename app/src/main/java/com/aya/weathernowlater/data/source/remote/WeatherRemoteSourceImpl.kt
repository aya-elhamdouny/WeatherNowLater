package com.aya.weathernowlater.data.source.remote

import com.aya.weathernowlater.BuildConfig
import com.aya.weathernowlater.data.source.remote.WeatherRemoteSource
import com.aya.weathernowlater.data.models.response.WeatherResponse
import com.aya.weathernowlater.data.source.remote.api.WeatherApi
import javax.inject.Inject

class WeatherRemoteSourceImpl @Inject constructor(private val weatherApi : WeatherApi) :
    WeatherRemoteSource {

    override suspend fun getWeatherFeed(countryName: String): WeatherResponse {
      val response =  weatherApi.getCurrentWeather(countryName , BuildConfig.API_KEY)
     return  response
    }
}


