package com.aya.weathernowlater.data.models.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteWeather(
    @SerializedName("description")
    @Expose
    var description: String?,
    @SerializedName("icon")
    @Expose
    var icon: String?,
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("main")
    @Expose
    var main: String?
)
