package com.example.shoppingapp.core.data.remote.source

import com.example.shoppingapp.core.data.model.LoginBody
import com.example.shoppingapp.core.data.model.LoginResponse
import com.example.shoppingapp.core.data.remote.api.AuthService
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val authService: AuthService
): AuthRemoteDataSource {
    override suspend fun login(username: String, password: String): Result<LoginResponse> {
        return runCatching { //try - catch
            authService.login(LoginBody(username, password))
        }
    }
}