package com.example.scootboost.data.model


class RequestException(val code:Int,message:String,body:Any? = null) :Exception(message)


sealed class Result<out R>{
    data class Success<out T>(val body:T) : Result<T>()
    data class Error<out E : Exception>(val exception:E): Result<E>()
}