package com.aya.weathernowlater.data.models.response

import com.aya.weathernowlater.data.models.remote.RemoteClouds
import com.aya.weathernowlater.data.models.remote.RemoteCoord
import com.aya.weathernowlater.data.models.remote.RemoteMainInfo
import com.aya.weathernowlater.data.models.remote.RemoteSys
import com.aya.weathernowlater.data.models.remote.RemoteWeather
import com.aya.weathernowlater.data.models.remote.RemoteWind
import com.aya.weathernowlater.domain.entites.Weather
import com.aya.weathernowlater.domain.entites.Wind
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class WeatherResponse(
    @SerializedName("base")
    @Expose
    var base: String?,
    @SerializedName("clouds")
    @Expose
    var clouds: RemoteClouds?,
    @SerializedName("cod")
    @Expose
    var cod: Int?,
    @SerializedName("coord")
    @Expose
    var coord: RemoteCoord?,
    @SerializedName("dt")
    @Expose
    var dt: Int?,
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("main")
    @Expose
    var main: RemoteMainInfo?,
    @SerializedName("name")
    @Expose
    var name: String?,
    @SerializedName("sys")
    @Expose
    var sys: RemoteSys?,
    @SerializedName("timezone")
    @Expose
    var timezone: Int?,
    @SerializedName("visibility")
    @Expose
    var visibility: Int?,
    @SerializedName("weather")
    @Expose
    var weather: List<RemoteWeather?>?,
    @SerializedName("wind")
    @Expose
    var wind: RemoteWind?
)

