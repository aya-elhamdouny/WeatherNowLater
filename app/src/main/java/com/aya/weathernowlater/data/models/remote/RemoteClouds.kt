package com.aya.weathernowlater.data.models.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteClouds(
    @SerializedName("all")
    @Expose
    var all: Int?
)
