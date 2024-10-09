package com.example.scootboost.routes

import androidx.compose.runtime.Immutable

interface Route{
    val route:String
}


@Immutable
object House: Route {
    override val route = "house"
}

@Immutable
object Login: Route {
    override val route = "login"
}

@Immutable
object Registration:Route{
    override val route = "registration"
}



val routesAll = listOf(House,Registration,Login)