package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.PersonDao
import com.example.data.database.entity.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class SecureDataBase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}