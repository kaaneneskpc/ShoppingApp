package com.example.shoppingapp.core.data.remote.api

import com.example.shoppingapp.core.data.model.LoginBody
import com.example.shoppingapp.core.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    suspend fun login(
        @Body requestBody: LoginBody
    ): LoginResponse

}