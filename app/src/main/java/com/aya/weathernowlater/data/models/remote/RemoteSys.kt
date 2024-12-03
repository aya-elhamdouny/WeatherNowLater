package com.aya.weathernowlater.data.models.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteSys(
    @SerializedName("country")
    @Expose
    var country: String?,
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("sunrise")
    @Expose
    var sunrise: Int?,
    @SerializedName("sunset")
    @Expose
    var sunset: Int?,
    @SerializedName("type")
    @Expose
    var type: Int?
)
