package com.example.tp3_examen.data.network

import com.example.tp3_examen.data.models.LoginResponse
import com.example.tp3_examen.data.models.User
import com.example.tp3_examen.data.shared.IAuthService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object AuthRetrofit : IAuthService {

    private const val BASE_URL = "https://fakestoreapi.com"

    val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    var client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl(BASE_URL)
        .build()

    val apiService: Api = retrofit.create(Api::class.java)

    override suspend fun login(user: User): LoginResponse {
        return apiService.login(user)
    }
}