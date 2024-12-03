package com.aya.weathernowlater.data.source.remote.mapper

import com.aya.weathernowlater.data.models.remote.RemoteWeather
import com.aya.weathernowlater.domain.entites.Weather
import javax.inject.Inject

class RemoteWeatherMapper @Inject constructor() : BaseRemoteModelMapper<RemoteWeather , Weather> {
    override fun convert(from: RemoteWeather?): Weather {
        return from?.let {
            Weather(
               weatherName =  it.main ?: "",
                weatherDescription =  it.description ?: "",
                icon =  it.icon ?: ""

            )
        }?: Weather()
    }

}