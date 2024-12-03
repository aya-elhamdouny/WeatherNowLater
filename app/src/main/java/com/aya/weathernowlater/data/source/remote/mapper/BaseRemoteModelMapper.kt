package com.aya.weathernowlater.data.source.remote.mapper

interface BaseRemoteModelMapper<From, To> {
    fun convert(from: From?): To
}