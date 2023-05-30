package com.example.shoppingapp.feature.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.shoppingapp.feature.login.LoginScreenRoute

const val loginNavigationRoute = "login_route"

fun NavGraphBuilder.loginScreen() {
    composable(loginNavigationRoute) {
        LoginScreenRoute()
    }
}