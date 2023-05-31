package com.example.shoppingapp.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.shoppingapp.feature.home.navigation.homeNavigationRoute
import com.example.shoppingapp.feature.home.navigation.homeScreen
import com.example.shoppingapp.feature.login.navigation.loginNavigationRoute
import com.example.shoppingapp.feature.login.navigation.loginScreen
import com.example.shoppingapp.feature.splash.navigation.splashNavigationRoute
import com.example.shoppingapp.feature.splash.navigation.splashScreen


@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier, startDestination: String = splashNavigationRoute) {
    NavHost(navController = navController, modifier = modifier, startDestination = startDestination) {
        loginScreen()
        homeScreen()
        splashScreen(navigateToLogin = {
            navController.navigate(loginNavigationRoute) {
                popUpTo(loginNavigationRoute) {
                    inclusive = true
                }
            }
        }, navigateToHome = {
            navController.navigate(homeNavigationRoute) {
                popUpTo(loginNavigationRoute) {
                    inclusive = true
                }
            }
        })
    }
}