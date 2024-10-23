package com.example.scootboost.api.auth.request

import com.example.scootboost.api.auth.service.AuthService
import com.example.scootboost.api.handlerRequest
import com.example.scootboost.config.RetrofitInstance
import com.example.scootboost.data.model.SignInDTO
import com.example.scootboost.data.model.SignInEmailDTO
import com.example.scootboost.data.model.SignUpDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



suspend fun login(dto:SignInDTO) = withContext(Dispatchers.IO){
    val service = RetrofitInstance.instance.create(AuthService::class.java)
    return@withContext service.login(dto).handlerRequest()
}

suspend fun loginEmail(dto:SignInEmailDTO) = withContext(Dispatchers.IO){
    val service = RetrofitInstance.instance.create(AuthService::class.java)
    return@withContext service.loginEmail(dto).handlerRequest()
}

suspend fun registration(dto:SignUpDTO) = withContext(Dispatchers.IO){
    val service = RetrofitInstance.instance.create(AuthService::class.java)
    return@withContext service.signup(dto).handlerRequest()
}