package com.example.shoppingapp.domain.usecase.login

import com.example.shoppingapp.core.data.model.LoginResponse
import com.example.shoppingapp.core.data.remote.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.IllegalArgumentException
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {
    operator fun invoke(username: String, password: String): Flow<LoginResponse> {
        return flow {
            val result = authRepository.login(username, password)
            (result.getOrNull() ?: throw IllegalArgumentException("error message")).also {
                emit(it)
            }
        }
    }
}