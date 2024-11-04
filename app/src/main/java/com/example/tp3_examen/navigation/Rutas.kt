package com.example.tp3_examen.navigation

sealed class Rutas(val ruta: String) {
    object HomeScreen : Rutas("homeScreen")
    object PagoDeServiciosScreen : Rutas("pagoDeServiciosScreen")
    object MenuScreen : Rutas("menuScreen")
    object MyAcountyScreen : Rutas("myAcountyScreen")
    object TransaccionsScreen : Rutas("transaccionsScreen")
    object MyCardScreen : Rutas("myCardScreen")
}