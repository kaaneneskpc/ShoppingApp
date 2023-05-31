package com.example.shoppingapp.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.shoppingapp.feature.home.HomeScreenRoute

const val homeNavigationRoute = "home_route"

fun NavGraphBuilder.homeScreen() {
    composable(homeNavigationRoute) {
        HomeScreenRoute()
    }
}