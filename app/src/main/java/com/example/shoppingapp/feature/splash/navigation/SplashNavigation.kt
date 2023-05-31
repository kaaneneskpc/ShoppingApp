package com.example.shoppingapp.feature.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.shoppingapp.feature.splash.SplashScreenRoute

const val splashNavigationRoute = "splash_route"

fun NavGraphBuilder.splashScreen(navigateToHome: () -> Unit, navigateToLogin: () -> Unit) {
    composable(splashNavigationRoute) {
        SplashScreenRoute(navigateToHome = navigateToHome, navigateToLogin = navigateToLogin)
    }
}