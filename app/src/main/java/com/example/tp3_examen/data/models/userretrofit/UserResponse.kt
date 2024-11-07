package com.example.tp3_examen.data.models.userretrofit

data class UserResponse (
    val address: UserAddress,
    val name: UserName,
    val id : Int = 0,
    val email : String = "",
    val username : String = "",
    val password : String = "",
    val phone : String = "",
    val __v : Int = 0
)
