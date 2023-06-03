package com.example.shoppingapp.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.shoppingapp.feature.profile.ProfileScreenRoute

const val profileNavigationRoute = "profile_route"

fun NavController.navigateToProfile(
    navOptions: NavOptions? = null,
) {
    this.navigate(profileNavigationRoute, navOptions)
}

fun NavGraphBuilder.profileScreen() {
    composable(profileNavigationRoute) {
        ProfileScreenRoute()
    }
}