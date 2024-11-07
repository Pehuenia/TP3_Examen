package com.example.tp3_examen.data.shared

import com.example.tp3_examen.data.models.LoginResponse
import com.example.tp3_examen.data.models.User
import com.example.tp3_examen.data.models.userretrofit.UserResponse

interface IGetUserService {
    suspend fun getUser(id: Int): UserResponse
}