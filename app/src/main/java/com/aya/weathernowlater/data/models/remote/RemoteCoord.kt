package com.aya.weathernowlater.data.models.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteCoord(
    @SerializedName("lat")
    @Expose
    var lat: Double?,
    @SerializedName("lon")
    @Expose
    var lon: Double?
)