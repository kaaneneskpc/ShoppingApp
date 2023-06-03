import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.shoppingapp.feature.mainappstate.MainAppState
import com.example.shoppingapp.feature.mainappstate.rememberMainAppState
import com.example.shoppingapp.feature.navigation.Icon
import com.example.shoppingapp.feature.navigation.MainNavHost
import com.example.shoppingapp.feature.navigation.TopLevelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    appState: MainAppState = rememberMainAppState(),
) {
    Scaffold(modifier = modifier,
        bottomBar = {
            AnimatedVisibility(visible = appState.shouldShowBottomBar) {
                AppNavBar(
                    destinations = AppDestinations(appState.topLevelDestinations),
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination
                )
            }
        }) {
        MainNavHost(
            navController = appState.navController,
            modifier = modifier.padding(it)
        )
    }
}

data class AppDestinations(
    val destinations: List<TopLevelDestination>
) : List<TopLevelDestination> by destinations

@Composable
internal fun AppNavBar(
    destinations: AppDestinations,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
) {
    NavigationBar {
        destinations.forEach { destination ->
            val selected =
                currentDestination?.hierarchy?.any { it.route == destination.route } == true
            NavigationBarItem(
                selected = selected,
                label = { Text(text = stringResource(id = destination.titleTextId)) },
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unSelectedIcon
                    }
                    AppIcon(icon = icon)
                })
        }
    }
}

@Composable
internal fun AppIcon(
    icon: Icon
) {
    when (icon) {
        is Icon.ImageVectorIcon -> androidx.compose.material3.Icon(
            imageVector = icon.imageVector,
            contentDescription = null
        )

        is Icon.DrawableResourceIcon -> androidx.compose.material3.Icon(
            painter = androidx.compose.ui.res.painterResource(id = icon.id),
            contentDescription = null
        )
    }
}