package com.example.scootboost.api

import com.example.scootboost.data.model.wrapper.WrapperDTO
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


suspend fun <T> Response<T>.handlerRequest():WrapperDTO<T> {
    return try{
        if(this.isSuccessful){
            withContext(Dispatchers.Main) {
                WrapperDTO(this@handlerRequest.body())
            }
        }
        else{
            withContext(Dispatchers.Main) {
                val code = this@handlerRequest.code()
                val message = this@handlerRequest.message()
                WrapperDTO(error = WrapperDTO.Error(code, message))
            }
        }
    }
    catch (e:CancellationException){
        WrapperDTO(error = WrapperDTO.Error.badRequest())
    }
}