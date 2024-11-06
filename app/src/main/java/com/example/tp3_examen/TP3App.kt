package com.example.tp3_examen

import android.app.Application
import com.google.firebase.FirebaseApp


class TP3App: Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }


}