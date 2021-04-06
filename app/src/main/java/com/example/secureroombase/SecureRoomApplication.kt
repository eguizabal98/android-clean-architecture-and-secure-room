package com.example.secureroombase

import android.app.Application
import androidx.room.Room
import com.example.data.database.SecureDataBase
import com.example.data.di.databaseModule
import com.example.data.di.repositoryModule
import com.example.domain.di.domainModule
import com.example.secureroombase.di.presenterModule
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

@Suppress("unused")
class SecureRoomApplication : Application() {

    private val appModules = listOf(presenterModule)
    private val domainModules = listOf(domainModule)
    private val dataModules = listOf(repositoryModule, databaseModule)

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SecureRoomApplication)
            modules(appModules + domainModules + dataModules + listOf(dataBaseSecure))
        }
    }

    private val dataBaseSecure = module {
        single {
            Room.databaseBuilder(androidContext(), SecureDataBase::class.java, "SecureDB")
                .fallbackToDestructiveMigration()
                .openHelperFactory(SupportFactory(SQLiteDatabase.getBytes(keyFromJNI().toCharArray())))
                .build()
        }
    }

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    private external fun keyFromJNI(): String
}