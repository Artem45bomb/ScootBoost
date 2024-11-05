package com.example.scootboost.data.model

data class SignUpDTO(
    val username:String,
    val email: String,
    val password: String,
    val type: Type,
    val userSettings: UserSettings?,
    val companySettings: CompanySettings?
){
    enum class Type{
        USER,COMPANY
    }

}