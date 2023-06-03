package com.example.shoppingapp.feature.productDetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.shoppingapp.feature.productDetail.ProductDetailRoute

const val productDetailNavigationRoute = "product_detail_route"
fun NavController.navigateToProductDetail(
    productId: Int,
    navOptions: NavOptions? = null,
) {
    this.navigate("$productDetailNavigationRoute/$productId", navOptions)
}

fun NavGraphBuilder.productDetailScreen() {
    composable(
        "$productDetailNavigationRoute/{productId}",
        arguments = listOf(
            navArgument("productId") {
                type = NavType.IntType
            }
        )
    ) {
        ProductDetailRoute()
    }
}