package com.example.shoppingapp.core.data.remote.repository

import com.example.shoppingapp.core.data.model.LoginResponse

interface AuthRepository {
    suspend fun login(username: String, password: String): Result<LoginResponse>
}