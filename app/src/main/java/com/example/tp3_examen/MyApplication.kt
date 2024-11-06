package com.example.tp3_examen

import android.app.Application
import com.example.tp3_examen.data.network.services.UserRepository
import com.google.firebase.firestore.FirebaseFirestore

class MyApplication : Application() {
    val userRepository: UserRepository by lazy {
        UserRepository(FirebaseFirestore.getInstance())
    }
}
