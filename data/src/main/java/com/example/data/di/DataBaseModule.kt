package com.example.data.di

import androidx.room.Room
import com.example.data.database.SecureDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), SecureDataBase::class.java, "SecureDB")
            .fallbackToDestructiveMigration()
            .build()
    }
    factory { get<SecureDataBase>().personDao() }
}