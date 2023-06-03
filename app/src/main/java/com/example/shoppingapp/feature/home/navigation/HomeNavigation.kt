package com.example.shoppingapp.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.shoppingapp.feature.home.HomeScreenRoute

const val homeNavigationRoute = "home_route"

fun NavController.navigateToHome(
    navOptions: NavOptions? = null,
) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(navigateToDetail: (Int) -> Unit) {
    composable(homeNavigationRoute) {
        HomeScreenRoute(navigateToDetail = navigateToDetail)
    }
}