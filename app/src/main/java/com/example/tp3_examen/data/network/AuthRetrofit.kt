package com.example.tp3_examen.data.network

import com.example.tp3_examen.data.models.LoginResponse
import com.example.tp3_examen.data.models.User
import com.example.tp3_examen.data.models.userretrofit.UserResponse
import com.example.tp3_examen.data.shared.IAuthService
import com.example.tp3_examen.data.shared.IGetUserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object AuthRetrofit : IAuthService, IGetUserService {

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
        val response = apiService.login(user)

        if (!response.isSuccessful) {
            when (response.code()) {
                401 -> throw Exception("Credenciales inválidas. Por favor, intente nuevamente.")
                402 -> throw Exception("El pago es requerido para acceder a este servicio.")
                else -> throw Exception("Error desconocido. Código de error: ${response.code()}")
            }
        }

        val loginResponse = response.body()

        if (loginResponse == null || loginResponse.token.isNullOrEmpty()) {
            throw Exception("Credenciales inválidas.")
        }

        return loginResponse
    }





    override suspend fun getUser(id: Int): UserResponse {
        return apiService.getUser(id)
    }
}