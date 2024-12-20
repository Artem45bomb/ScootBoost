package com.example.scootboost.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{
    private const val BASE_URL = "http://213.171.9.79:8081/"
    private var _instance:Retrofit? = null

    val instance:Retrofit
        get():Retrofit {
            if(_instance == null){
                _instance = Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return _instance!!
        }

}