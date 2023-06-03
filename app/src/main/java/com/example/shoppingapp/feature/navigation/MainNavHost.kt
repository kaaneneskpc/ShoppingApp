package com.example.shoppingapp.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.shoppingapp.feature.category.navigation.categoryScreen
import com.example.shoppingapp.feature.home.navigation.homeNavigationRoute
import com.example.shoppingapp.feature.home.navigation.homeScreen
import com.example.shoppingapp.feature.login.navigation.loginNavigationRoute
import com.example.shoppingapp.feature.login.navigation.loginScreen
import com.example.shoppingapp.feature.productDetail.navigation.navigateToProductDetail
import com.example.shoppingapp.feature.productDetail.navigation.productDetailScreen
import com.example.shoppingapp.feature.profile.navigation.profileScreen
import com.example.shoppingapp.feature.splash.navigation.splashNavigationRoute
import com.example.shoppingapp.feature.splash.navigation.splashScreen


@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = splashNavigationRoute
) {
    NavHost(
        modifier = modifier,
        navController = navController, startDestination = startDestination
    ) {
        loginScreen()
        homeScreen(navigateToDetail = { id ->
            navController.navigateToProductDetail(id)
        })
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
        profileScreen()
        categoryScreen()
        productDetailScreen()
    }
}