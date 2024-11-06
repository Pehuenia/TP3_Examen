package com.example.tp3_examen.viewmodels.drawerviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NavDrawerViewModel(): ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email
/*
    fun updateEmail() {
        val user = Utility().decodeJWT(Token.token)
        _email.value = user.email
    }

 */

}