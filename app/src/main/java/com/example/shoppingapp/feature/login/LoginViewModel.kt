package com.example.shoppingapp.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.example.shoppingapp.core.common.Resource
import com.example.shoppingapp.core.common.asResource
import com.example.shoppingapp.domain.usecase.login.LoginUseCase
import com.example.shoppingapp.feature.profile.navigation.navigateToProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {
    private val _uiState: MutableStateFlow<LoginUIState> = MutableStateFlow(LoginUIState())
    val uiState = _uiState

    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun onLogin() {
        viewModelScope.launch {
            loginUseCase(_uiState.value.email, "83r5^_") // I can use fakeStore API login password. You can change with _uiState.value.password for another login information's
                .asResource()
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _uiState.value = _uiState.value.copy(loading = true)
                        }

                        is Resource.Error -> {
                            _uiState.value = _uiState.value.copy(loading = false)
                        }

                        is Resource.Success -> {
                            _uiState.value = _uiState.value.copy(loading = false)
                        }
                    }
                }.launchIn(this)
        }
    }
}

data class LoginUIState(
    val loading: Boolean = false,
    val email: String = "",
    val password: String = ""
)