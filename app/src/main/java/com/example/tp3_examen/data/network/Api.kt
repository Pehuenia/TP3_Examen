package com.example.tp3_examen.data.network

import com.example.tp3_examen.data.models.LoginResponse
import com.example.tp3_examen.data.models.User
import com.example.tp3_examen.data.models.userretrofit.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
    @POST("/auth/login")
    suspend fun login(@Body user: User): Response<LoginResponse>

    @GET("/users/{id}")
    suspend fun getUser(@Path("id") id: Int): UserResponse
}