package com.example.tp3_examen.data.shared

import com.example.tp3_examen.data.models.LoginResponse
import com.example.tp3_examen.data.models.User

interface IAuthService {
    suspend fun login(user: User): LoginResponse
}