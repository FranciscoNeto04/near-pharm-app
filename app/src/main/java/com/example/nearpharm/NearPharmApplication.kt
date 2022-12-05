package com.example.nearpharm

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NearPharmApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(
                this@NearPharmApplication
            )
            modules (
                nearPharmModule
            )
        }
    }
}