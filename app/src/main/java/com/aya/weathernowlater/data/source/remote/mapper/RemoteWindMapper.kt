package com.aya.weathernowlater.data.source.remote.mapper

import com.aya.weathernowlater.data.models.remote.RemoteWind
import com.aya.weathernowlater.domain.entites.Wind
import javax.inject.Inject

class RemoteWindMapper @Inject constructor() : BaseRemoteModelMapper<RemoteWind, Wind> {

    override fun convert(from: RemoteWind?): Wind {
        return from?.let {
            Wind(
                speed = it.speed ?: 0.0
            )
        } ?: Wind()
    }
}




