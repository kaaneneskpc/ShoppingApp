package com.example.shoppingapp.feature.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.shoppingapp.R
import com.example.shoppingapp.feature.category.navigation.categoryNavigationRoute
import com.example.shoppingapp.feature.home.navigation.homeNavigationRoute
import com.example.shoppingapp.feature.profile.navigation.profileNavigationRoute

enum class TopLevelDestination(
    val route: String,
    val selectedIcon: Icon,
    val unSelectedIcon: Icon,
    val titleTextId: Int
) {
    HOME(
        route = homeNavigationRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Home),
        unSelectedIcon = Icon.ImageVectorIcon(AppIcons.HomeOutlined),
        titleTextId = R.string.home_title
    ),
    CATEGORY(
        route = categoryNavigationRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Category),
        unSelectedIcon = Icon.ImageVectorIcon(AppIcons.CategoryOutlined),
        titleTextId = R.string.category_title
    ),
    PROFILE(
        route = profileNavigationRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Person),
        unSelectedIcon = Icon.ImageVectorIcon(AppIcons.PersonOutlined),
        titleTextId = R.string.profile_title
    )
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()

    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}

object AppIcons {
    val Home = Icons.Default.Home
    val HomeOutlined = Icons.Outlined.Home
    val Category = Icons.Default.Info
    val CategoryOutlined = Icons.Outlined.Info
    val Person = Icons.Default.Person
    val PersonOutlined = Icons.Outlined.Person
}