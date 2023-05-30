package com.example.shoppingapp.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.shoppingapp.feature.login.navigation.loginNavigationRoute
import com.example.shoppingapp.feature.login.navigation.loginScreen


@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier, startDestination: String = loginNavigationRoute) {
    NavHost(navController = navController, modifier = modifier, startDestination = startDestination) {
        loginScreen()
    }
}