package com.aya.weathernowlater.di


import com.aya.weathernowlater.data.source.remote.WeatherRemoteSourceImpl
import com.aya.weathernowlater.data.repository.WeatherRepositoryImpl
import com.aya.weathernowlater.data.source.remote.WeatherRemoteSource
import com.aya.weathernowlater.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository


    @Binds
    abstract fun bindWeatherRemoteSource( weatherRemoteSourceImpl: WeatherRemoteSourceImpl): WeatherRemoteSource





}