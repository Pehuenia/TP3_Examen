package com.example.tp3_examen.data.shared

import com.example.tp3_examen.data.models.LoginResponse
import com.example.tp3_examen.data.models.UserComplete
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginUseCase(
    private val authService: IAuthService
) {
    suspend fun execute(user: UserComplete): LoginResponse = withContext(Dispatchers.IO) {
        authService.login(user)
    }
}