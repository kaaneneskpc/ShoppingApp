package com.example.shoppingapp.core.data.remote.source

import com.example.shoppingapp.core.data.model.LoginResponse

interface AuthRemoteDataSource {
    suspend fun login(username: String, password: String): Result<LoginResponse>
}