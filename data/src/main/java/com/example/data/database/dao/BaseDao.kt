package com.example.data.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<in T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntity(entity: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateEntity(entity: T)

    @Delete
    suspend fun deleteEntity(entity: T)
}