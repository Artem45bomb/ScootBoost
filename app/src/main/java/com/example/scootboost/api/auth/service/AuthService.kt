package com.example.scootboost.api.auth.service

import com.example.scootboost.data.model.JwtResponseDTO
import com.example.scootboost.data.model.SignInDTO
import com.example.scootboost.data.model.SignInEmailDTO
import com.example.scootboost.data.model.SignUpDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/auth/login")
    suspend fun login(@Body dto:SignInDTO):Response<JwtResponseDTO>

    @POST("/auth/login/email")
    suspend fun loginEmail(@Body dto:SignInEmailDTO):Response<JwtResponseDTO>

    @POST("auth/signup")
    suspend fun signup(@Body dto:SignUpDTO):Response<JwtResponseDTO>
}