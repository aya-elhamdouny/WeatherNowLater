package com.aya.weathernowlater.data.utils

sealed class ResourceState<out T : Any> {
    object Loading : ResourceState<Nothing>()
    data class Success<out T : Any>(val data: T) : ResourceState<T>()
    data class Error(val errorMessage: String) : ResourceState<Nothing>()
}