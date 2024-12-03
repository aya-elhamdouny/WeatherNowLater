package com.aya.weathernowlater.data.source.remote.mapper

import com.aya.weathernowlater.data.models.remote.RemoteMainInfo
import com.aya.weathernowlater.domain.entites.MainInfo
import javax.inject.Inject

class RemoteMainInfoMapper @Inject constructor() : BaseRemoteModelMapper<RemoteMainInfo , MainInfo> {
    override fun convert(from: RemoteMainInfo?): MainInfo {
       return  from?.let {
           MainInfo(
               pressure = it.pressure ?: 0,
               humindty = it.humidity ?: 0
           )
       }?: MainInfo()
    }
}
