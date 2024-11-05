package com.example.tp3_examen.data.network

import com.example.tp3_examen.data.models.LoginResponse
import com.example.tp3_examen.data.models.UserComplete
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("/auth/login")
    suspend fun login(@Body user: UserComplete): LoginResponse
}