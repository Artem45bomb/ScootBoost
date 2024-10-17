package com.example.scootboost.routes

import androidx.compose.runtime.Immutable
import com.example.scootboost.screen.HouseRouter
import com.example.scootboost.screen.auth.LoginRouter
import com.example.scootboost.screen.auth.registration.RegistrationRouter
import com.example.scootboost.screen.auth.registration.company.CompanyRouter
import kotlin.reflect.full.findAnnotation

interface RouteBase{
    val route:String
    val groupId: List<String>
}
interface RouterType


@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.CLASS,
)
annotation class Router(val route:String, val groupId:Array<String> = [])



fun createRoute(
    route:String,
    groupId:List<String> = listOf("")
) = @Immutable object:RouteBase{
    override val route = route
    override val groupId = groupId
}

inline fun <reified T : RouterType> createRoute():RouteBase {
    val routeClass = T::class
    val annotation = routeClass.findAnnotation<Router>()

    if (annotation != null) {
        return createRoute(
            annotation.route,
            annotation.groupId.toList()
        )
    } else {
        throw IllegalArgumentException("Class ${routeClass.simpleName} not has annotation Router.")
    }
}


val House = createRoute<HouseRouter>()
val Login = createRoute<LoginRouter>()
val Registration = createRoute<RegistrationRouter>()
val RegistrationCompany = createRoute<CompanyRouter>()


internal val routesAll = listOf(
    House,
    Registration,
    Login,
    RegistrationCompany
)