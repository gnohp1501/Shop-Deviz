package com.example.shopdeviz

import android.app.Application
import com.example.shopdeviz.presentation.di.diModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@Application)
            modules(diModules)
        }
    }
}