package com.aya.weathernowlater.data.models.remote

import com.google.gson.annotations.SerializedName

data class RemoteMainWeather(
    var coord: RemoteCoord,
    var weather: List<RemoteWeather>,
    var base: String,
    var main: RemoteMainInfo,
    var visibility: Int,
    var wind: RemoteWind,
    var clouds: RemoteClouds,
    var dt: Long,
    var sys: RemoteSys,
    var timezone: Int,
    var id: Int,
    var name: String,
    var cod: Int
)