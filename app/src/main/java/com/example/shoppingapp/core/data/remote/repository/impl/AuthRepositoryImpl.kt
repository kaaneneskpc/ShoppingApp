package com.example.shoppingapp.core.data.remote.repository.impl

import com.example.shoppingapp.core.data.model.LoginResponse
import com.example.shoppingapp.core.data.remote.repository.AuthRepository
import com.example.shoppingapp.core.data.remote.source.AuthRemoteDataSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
): AuthRepository {
    override suspend fun login(username: String, password: String): Result<LoginResponse> {
        return authRemoteDataSource.login(username, password)
    }
}