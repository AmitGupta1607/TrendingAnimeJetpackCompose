package com.example.animelistcompose.data.api

sealed class Resource<T> {

    data class Success<T>(val data:T?=null):Resource<T>()
    data class Error<T>(val errorMessage:String):Resource<T>()
}