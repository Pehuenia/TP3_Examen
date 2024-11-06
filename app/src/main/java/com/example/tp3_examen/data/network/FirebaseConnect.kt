package com.example.tp3_examen.data.network

import com.google.firebase.firestore.FirebaseFirestore

object FirebaseConnect {
    val firestore: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }
}
