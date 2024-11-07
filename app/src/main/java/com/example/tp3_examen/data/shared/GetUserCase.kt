package com.example.tp3_examen.data.shared

import com.example.tp3_examen.data.models.LoginResponse
import com.example.tp3_examen.data.models.User
import com.example.tp3_examen.data.models.userretrofit.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserCase(
    private val getUserService: IGetUserService
) {
    suspend fun execute(id: Int): UserResponse = withContext(Dispatchers.IO) {
        getUserService.getUser(id)
    }
}