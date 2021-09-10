package com.example.fistprojectcompose.common

sealed class Resource<T> (val data: T? = null , val message: String? = null){
    class Sucess<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}