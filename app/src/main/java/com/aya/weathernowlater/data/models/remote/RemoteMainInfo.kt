package com.aya.weathernowlater.data.models.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteMainInfo(
    @SerializedName("feels_like")
    @Expose
    var feelsLike: Double?,
    @SerializedName("grnd_level")
    @Expose
    var grndLevel: Int?,
    @SerializedName("humidity")
    @Expose
    var humidity: Int?,
    @SerializedName("pressure")
    @Expose
    var pressure: Int?,
    @SerializedName("sea_level")
    @Expose
    var seaLevel: Int?,
    @SerializedName("temp")
    @Expose
    var temp: Double?,
    @SerializedName("temp_max")
    @Expose
    var tempMax: Double?,
    @SerializedName("temp_min")
    @Expose
    var tempMin: Double?
)
