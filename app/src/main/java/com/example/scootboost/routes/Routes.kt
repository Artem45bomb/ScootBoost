package com.example.scootboost.routes

import com.example.scootboost.screen.HouseRouter
import com.example.scootboost.screen.techSupport.TechSupportRouter
import com.example.scootboost.screen.auth.LoginRouter
import com.example.scootboost.screen.auth.registration.RegistrationRouter
import com.example.scootboost.screen.auth.registration.code.SendCodeRouter
import com.example.scootboost.screen.auth.registration.company.CompanyRouter


val House = createRoute<HouseRouter>()
val Login = createRoute<LoginRouter>()
val Registration = createRoute<RegistrationRouter>()
val RegistrationCompany = createRoute<CompanyRouter>()
val SendCode = createRoute<SendCodeRouter>()
val TechSupport = createRoute<TechSupportRouter>()

internal val routesAll = listOf(
    House,
    Registration,
    Login,
    RegistrationCompany,
    TechSupport
)