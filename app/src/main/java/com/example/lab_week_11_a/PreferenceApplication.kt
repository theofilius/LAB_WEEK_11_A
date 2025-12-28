package com.example.lab_week_11_a

import android.app.Application

class PreferenceApplication : Application() {
    lateinit var preferenceWrapper: PreferenceWrapper
    override fun onCreate() {
        super.onCreate()
        val Context = null
        preferenceWrapper = PreferenceWrapper(
            getSharedPreferences("prefs", MODE_PRIVATE)
        )
    }
}