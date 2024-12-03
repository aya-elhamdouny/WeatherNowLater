package com.aya.weathernowlater.data.repository

import com.aya.weathernowlater.data.utils.ResourceState
import androidx.lifecycle.MutableLiveData
import com.aya.weathernowlater.data.models.response.WeatherResponse

import com.aya.weathernowlater.data.source.remote.WeatherRemoteSource
import com.aya.weathernowlater.data.source.remote.mapper.RemotWeatherResponseMapper
import com.aya.weathernowlater.domain.entites.MainWeather
import com.aya.weathernowlater.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteSource: WeatherRemoteSource,
    private val remoteWeatherResponseMapper: RemotWeatherResponseMapper
) : WeatherRepository {

    override suspend fun getCurrentWeather(countryName: String): MutableLiveData<ResourceState<MainWeather>> {
        val weatherLiveData = MutableLiveData<ResourceState<MainWeather>>()
        weatherLiveData.postValue(ResourceState.Loading)
        withContext(Dispatchers.IO) {
            try {
                val response = remoteSource.getWeatherFeed(countryName)
                val mappedResponse  = remoteWeatherResponseMapper.convert(response)
                if (mappedResponse.weather.isNotEmpty()){
                    mappedResponse.weather = listOf(mappedResponse.weather[0])
                    weatherLiveData.postValue(ResourceState.Success(mappedResponse))
                } else {
                    weatherLiveData.postValue(ResourceState.Error("Invalid or empty data"))
                }
            } catch (e: IOException) {
                weatherLiveData.postValue(
                    ResourceState.Error(
                        ErrorType.NetworkError().toString()

                    )
                )
            } catch (e: HttpException) {
                weatherLiveData.postValue(
                    ResourceState.Error(
                        ErrorType.DataIssue().toString()

                    )
                )
            } catch (e: Exception) {
                weatherLiveData.postValue(
                    ResourceState.Error(
                        ErrorType.EmptyData().toString()

                    )
                )
            }
        }
        return weatherLiveData
    }
}




