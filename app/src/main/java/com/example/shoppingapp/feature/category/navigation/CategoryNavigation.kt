package com.example.shoppingapp.feature.category.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.shoppingapp.feature.category.CategoryScreenRoute

const val categoryNavigationRoute = "category_route"

fun NavController.navigateToCategory(
    navOptions: NavOptions? = null,
) {
    this.navigate(categoryNavigationRoute, navOptions)
}

fun NavGraphBuilder.categoryScreen() {
    composable(categoryNavigationRoute) {
        CategoryScreenRoute()
    }
}