package com.example.scootboost.data.model

import com.example.scootboost.data.view.Registration


data class UserRegistrationData (
    val firstname:String ,
    val lastname:String,
    val email:String,
    val password:String,
    val phone: String) : Registration