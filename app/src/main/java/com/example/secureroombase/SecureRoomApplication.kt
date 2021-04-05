package com.example.secureroombase

import android.app.Application
import com.example.data.di.databaseModule
import com.example.data.di.repositoryModule
import com.example.domain.di.domainModule
import com.example.secureroombase.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SecureRoomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SecureRoomApplication)
            modules(appModules + domainModules + dataModules)
        }
    }
}

val appModules = listOf(presenterModule)
val domainModules = listOf(domainModule)
val dataModules = listOf(repositoryModule, databaseModule)