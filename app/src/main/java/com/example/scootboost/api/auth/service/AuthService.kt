package com.example.scootboost.api.auth.service

import com.example.scootboost.data.model.JwtResponseDTO
import com.example.scootboost.data.model.SignInDTO
import com.example.scootboost.data.model.SignInEmailDTO
import com.example.scootboost.data.model.SignUpDTO
import com.squareup.wire.Service
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


private const val SERVICE_AUTH: String = "authorization/auth/"
interface AuthService {

    @POST("$SERVICE_AUTH/login")
    suspend fun login(@Body dto:SignInDTO):Response<JwtResponseDTO>

    @POST("$SERVICE_AUTH/login/email")
    suspend fun loginEmail(@Body dto:SignInEmailDTO):Response<JwtResponseDTO>

    @POST("$SERVICE_AUTH/signup")
    suspend fun signup(@Body dto:SignUpDTO):Response<JwtResponseDTO>
}