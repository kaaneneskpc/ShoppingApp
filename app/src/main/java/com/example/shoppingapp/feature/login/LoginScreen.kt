package com.example.shoppingapp.feature.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.shoppingapp.ui.theme.ShoppingAppTheme

@Composable
internal fun LoginScreenRoute(modifier: Modifier = Modifier, loginViewModel: LoginViewModel = hiltViewModel()) {
    val loginUIState by loginViewModel.uiState.collectAsStateWithLifecycle()
    LoginScreen(modifier = modifier, loginUIState = loginUIState,
        onEmailValueChange = loginViewModel::onEmailChange,
        onPasswordValueChange = loginViewModel::onPasswordChange)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginUIState: LoginUIState,
    onEmailValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit) {
    Scaffold {
        Content(modifier = modifier.padding(it),
            loginUIState = loginUIState,
            onEmailValueChange = onEmailValueChange,
            onPasswordValueChange = onPasswordValueChange)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Content(modifier: Modifier = Modifier,
                    loginUIState: LoginUIState,
                    onEmailValueChange: (String) -> Unit,
                    onPasswordValueChange: (String) -> Unit) {
    Column(modifier = modifier.fillMaxSize().padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Login Screen")
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email"
                )
            },

            value = loginUIState.email,
            onValueChange = onEmailValueChange
        )

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            label = {
                Text(text = "Password")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password"
                )
            },
            value = loginUIState.password,
            onValueChange = onPasswordValueChange
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(onClick = {}) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(onClick = {}) {
            Text(text = "Google Sign In")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ShoppingAppTheme {
        Content(
            loginUIState = LoginUIState(password = "123", email = "compose"),
            onEmailValueChange = {},
            onPasswordValueChange = {})
    }
}