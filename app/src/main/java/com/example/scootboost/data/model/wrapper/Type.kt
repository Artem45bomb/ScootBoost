package com.example.scootboost.data.model.wrapper




data class WrapperDTO<T>(val response:T? = null, val error:Error? = null) {
    class Error(val code:Int, message:String, body: Any? = null){
        companion object {
            @JvmStatic
            fun badRequest():Error =Error(400,"Bad Request")
        }
    }
}