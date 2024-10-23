package com.example.scootboost.data.view

import androidx.lifecycle.ViewModel
import com.example.scootboost.data.model.UserRegistrationData
import retrofit2.http.Body

enum class TypeRegistration{
    COMPANY,USER
}

interface Registration

data class RegistrationData(val type:TypeRegistration,val body: Registration)


class RegistrationView:ViewModel() {
    var data = RegistrationData(TypeRegistration.USER,UserRegistrationData("","","","",""))


    fun setData(value:Registration,type: TypeRegistration = TypeRegistration.USER){
        data = RegistrationData(type,value)
    }
}