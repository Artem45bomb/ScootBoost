package com.example.scootboost.api.auth.request

import com.example.scootboost.api.auth.service.OAuthService
import com.example.scootboost.api.handlerRequest
import com.example.scootboost.config.RetrofitInstance
import com.example.scootboost.data.model.SignInGoogleId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun loginGoogle(dto: SignInGoogleId) = withContext(Dispatchers.IO){
    val service = RetrofitInstance.instance.create(OAuthService::class.java)
    return@withContext service.login(dto).handlerRequest()
}