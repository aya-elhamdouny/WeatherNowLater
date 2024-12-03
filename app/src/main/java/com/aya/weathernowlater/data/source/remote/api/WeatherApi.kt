package com.aya.weathernowlater.data.source.remote.api

import com.aya.weathernowlater.data.models.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String
    ): WeatherResponse

//    @GET("forecast/daily")
//    suspend fun get7DayForecast(@Query("q") cityName: String, @Query("appid") apiKey: String): ForecastResponse
}
