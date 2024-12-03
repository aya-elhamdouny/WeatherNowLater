package com.aya.weathernowlater.presentation.weather

import com.aya.weathernowlater.domain.entites.MainWeather

data class WeatherUiState(
    val weather: MainWeather = MainWeather(),
    val isLoading: Boolean = false,
    val errorMessage: String = "",
)
