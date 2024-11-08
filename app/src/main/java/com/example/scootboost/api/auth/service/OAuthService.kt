package com.example.scootboost.api.auth.service

import com.example.scootboost.data.model.JwtResponseDTO
import com.example.scootboost.data.model.SignInGoogleId
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


private const val BASE_URL = "oauth"

interface OAuthService {
    @POST("$BASE_URL/login")
    suspend fun login(@Body body:SignInGoogleId):Response<JwtResponseDTO>
}