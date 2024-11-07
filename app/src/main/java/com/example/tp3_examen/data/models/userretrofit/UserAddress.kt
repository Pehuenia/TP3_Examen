package com.example.tp3_examen.data.models.userretrofit

data class UserAddress (
    val geolocation : UserGeolocation,
    val city : String = "",
    val street : String = "",
    val number : Int = 0,
    val zipcode : String = "",
)