package com.example.data.di

import com.example.data.database.SecureDataBase
import org.koin.dsl.module

val databaseModule = module {
//    single {
//        Room.databaseBuilder(androidContext(), SecureDataBase::class.java, "SecureDB")
//            .fallbackToDestructiveMigration()
//            .openHelperFactory(SupportFactory(SQLiteDatabase.getBytes("TestKey".toCharArray())))
//            .build()
//    }
    factory { get<SecureDataBase>().personDao() }
}