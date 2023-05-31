package com.example.shoppingapp.feature.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun SplashScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
    navigateToLogin: () -> Unit
) {
    val splashUiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.uiState) {
        viewModel.uiState.collect {
            if (it.navigateToLogin) navigateToLogin()
            if (it.navigateToHome) navigateToHome()
        }
    }

    SplashScreen(modifier = modifier)
}

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    //Can you modify anything you want
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Splash Screen")
    }
}