package com.aya.weathernowlater.data.models.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteWind(
    @SerializedName("deg")
    @Expose
    var deg: Int?,
    @SerializedName("speed")
    @Expose
    var speed: Double?
)
