package com.example.scootboost.data.model;

data class CompanySettings(
    val companyName:String,
    val addressURL:String,
    val typeCompany: TypeCompany
){
    enum class TypeCompany{
        LLC,
        JSC,
        PJSC,
        CJSC,
        GP,
        LLS,
        SA
    }
}
