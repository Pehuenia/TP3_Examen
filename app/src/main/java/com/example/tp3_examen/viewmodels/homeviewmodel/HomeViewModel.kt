package com.example.tp3_examen.viewmodels.homeviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3_examen.data.models.BankData
import com.example.tp3_examen.data.models.User
import com.example.tp3_examen.data.models.userretrofit.UserName
import com.example.tp3_examen.data.network.services.UserRepository
import com.example.tp3_examen.data.shared.GetUserCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val getUserCase: GetUserCase) : ViewModel() {

    sealed class UserDataState {
        object Loading : UserDataState()
        data class Success(val userName: UserName) : UserDataState()
        data class Error(val exception: Throwable) : UserDataState()
    }

    private val _userDataState = MutableLiveData<UserDataState>()

    val userDataState: LiveData<UserDataState> get() = _userDataState

    fun getUser() {
        _userDataState.value = UserDataState.Loading
        viewModelScope.launch {
            try {
                val userResponse = getUserCase.execute(1)
                _userDataState.value = UserDataState.Success(userResponse.name)
            } catch (e: Exception) {
                _userDataState.value = UserDataState.Error(e)
            }
        }
    }

}