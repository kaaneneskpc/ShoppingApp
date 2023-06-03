package com.example.shoppingapp.feature.login.navigation

import LoginScreenRoute
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val loginNavigationRoute = "login_route"

fun NavGraphBuilder.loginScreen() {
    composable(loginNavigationRoute) {
        LoginScreenRoute()
    }
}