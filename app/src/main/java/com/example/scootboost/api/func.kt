package com.example.scootboost.api

import com.example.scootboost.data.model.wrapper.RequestException
import com.example.scootboost.data.model.wrapper.Result
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response





fun <T> Response<T>.handlerRequest(): Result<Any> {
    if(this.isSuccessful){
        return Result.Success(this.body()!!)
    }
    else{
        val code = this.code()
        val message = this.message()
        val body = this.errorBody()
        return Result.Error(RequestException(code,message,body))
    }
}