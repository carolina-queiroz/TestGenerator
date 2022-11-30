package com.example.testgenerator.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestGenerator : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TestGenerator)
            modules(networkModules)
            modules(repositoryModules)
            modules(viewmodelModules)
        }

    }

}