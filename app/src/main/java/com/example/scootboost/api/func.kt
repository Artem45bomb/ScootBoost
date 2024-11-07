package com.example.scootboost.api

import com.example.scootboost.data.model.RequestException
import com.example.scootboost.data.model.Result
import retrofit2.Response





fun <T> Response<T>.handlerRequest(): Result<T> {
    if(this.isSuccessful){
        return Result.Success(this.body()!!)
    }
    else{
        val code = this.code()
        val message = this.message()
        val body = this.errorBody()
        throw RequestException(code,message,body)
    }
}

fun isNotEmpty(vararg args:String):Boolean{
    return args.isNotEmpty() && args.all {it.isNotEmpty()}
}



