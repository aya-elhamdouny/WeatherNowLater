package com.aya.weathernowlater.presentation.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aya.weathernowlater.data.models.response.WeatherResponse
import com.aya.weathernowlater.data.source.remote.RemoteConfig.DEFAULT_WEATHER_DESTINATION
import com.aya.weathernowlater.data.utils.ResourceState

import com.aya.weathernowlater.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
) : ViewModel() {

    private val _weatherState = MutableLiveData<WeatherUiState>().apply {
        value = WeatherUiState( isLoading = true)
    }
    val uiState: LiveData<WeatherUiState> = _weatherState

    private val _searchWidgetState = MutableLiveData<SearchWidgetState>().apply {
        value = SearchWidgetState.CLOSED
    }
    val searchWidgetState: LiveData<SearchWidgetState> = _searchWidgetState

    private val _searchTextState = MutableLiveData<String>().apply {
        value = ""
    }
    val searchTextState: LiveData<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    init {
        getWeather()
    }

    fun getWeather(city: String = DEFAULT_WEATHER_DESTINATION) {
        viewModelScope.launch {
            val weatherLiveData= repository.getCurrentWeather(city)
            weatherLiveData.observeForever { resourceState ->
                when (resourceState) {
                    is ResourceState.Loading -> {
                        _weatherState.value = WeatherUiState(isLoading = true)
                    }

                    is ResourceState.Success -> {
                        _weatherState.value = WeatherUiState(weather = resourceState.data)
                    }

                    is ResourceState.Error -> {
                        _weatherState.value = WeatherUiState(errorMessage = resourceState.errorMessage)
                    }
                }
            }
        }

        }
    }



