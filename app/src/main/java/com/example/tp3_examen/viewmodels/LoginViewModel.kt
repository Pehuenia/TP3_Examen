package com.example.tp3_examen.viewmodels

import android.util.Log
import androidx.compose.runtime.State
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

    private var _loginResponse = mutableStateOf<LoginResponse?>(null)
    private var _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> get() = _errorMessage
    val token: State<LoginResponse?> get() = _loginResponse

    fun login(email: String, password: String) {
        val user = User(email, password)
        viewModelScope.launch {
            try {
                _errorMessage.value = null

                _loginResponse.value = loginUseCase.execute(user)

            } catch (e: Exception) {
                _errorMessage.value = e.message
                _loginResponse.value = null
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