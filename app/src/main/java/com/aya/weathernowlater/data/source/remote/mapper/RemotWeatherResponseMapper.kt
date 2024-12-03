package com.aya.weathernowlater.data.source.remote.mapper

import com.aya.weathernowlater.data.models.response.WeatherResponse
import com.aya.weathernowlater.domain.entites.MainWeather
import javax.inject.Inject

class RemotWeatherResponseMapper @Inject constructor(
    private val remoteWeatherMapper: RemoteWeatherMapper,
    private val remoteMainInfoMapper: RemoteMainInfoMapper,
    private val remoteWindMapper: RemoteWindMapper
) : BaseRemoteModelMapper<WeatherResponse, MainWeather> {
    override fun convert(from: WeatherResponse?): MainWeather {
        return from?.let {
            val mainWeather = remoteMainInfoMapper.convert(it.main)
            val wind = remoteWindMapper.convert(it.wind)
            val weatherList = it.weather?.map { item -> remoteWeatherMapper.convert(item) } ?: emptyList()
            MainWeather(
                pressure = mainWeather.pressure,
                humidity = mainWeather.humindty,
                windSpeed = wind.speed,
                weather = weatherList,
                countryName = it.name ?: ""
            )
        } ?: MainWeather()
    }
}