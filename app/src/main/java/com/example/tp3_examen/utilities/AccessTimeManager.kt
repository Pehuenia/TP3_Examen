package com.example.tp3_examen.utilities


import android.content.Context
import android.content.SharedPreferences
import java.text.SimpleDateFormat
import java.util.*

object AccessTimeManager {
    private const val PREFS_NAME = "access_prefs"
    private const val LAST_ACCESS_KEY = "last_access"

    fun getLastAccessTime(context: Context): String? {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(LAST_ACCESS_KEY, null)
    }

    fun setLastAccessTime(context: Context) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        val currentTime = SimpleDateFormat("MMM dd, yyyy h:mm a", Locale.getDefault()).format(Date())
        editor.putString(LAST_ACCESS_KEY, currentTime)
        editor.apply()
    }

    fun isFirstAccess(context: Context): Boolean {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(LAST_ACCESS_KEY, null) == null
    }
}