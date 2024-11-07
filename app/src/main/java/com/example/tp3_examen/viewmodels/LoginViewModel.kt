package com.example.tp3_examen.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.tp3_examen.data.models.LoginResponse
import com.example.tp3_examen.data.models.User
import com.example.tp3_examen.data.shared.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private var loginResponse = mutableStateOf<LoginResponse?>(null)
    var token = mutableStateOf<String?>(null)

    fun login(email: String, password: String) {
        val user = User(email, password)
        Log.d("viewmodel", user.toString())
        viewModelScope.launch {
            Log.d("viewmodel", "entro aca")
            try {
                loginResponse.value = loginUseCase.execute(user)
                token.value = loginResponse.value?.token
            } catch (e: Exception) {
                loginResponse.value = null
            }
        }
    }
    companion object {
        fun provideFactory(loginUseCase: LoginUseCase): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return LoginViewModel(loginUseCase) as T
                }
            }
    }
}