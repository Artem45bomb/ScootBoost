package com.example.scootboost.data.model

import com.example.scootboost.data.view.Registration


data class CompanyRegistrationData (
    val email:String ,
    val phone:String,
    val urlCompany:String,
    val password:String,
    val nameCompany: String) : Registration