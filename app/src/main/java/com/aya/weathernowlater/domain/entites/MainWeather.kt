package com.aya.weathernowlater.domain.entites

data class MainWeather(
    var weather: List<Weather> = emptyList(),
    var pressure: Int = 0,
    var humidity: Int = 0,
    var windSpeed: Double = 0.0,
    var countryName: String = ""
)
