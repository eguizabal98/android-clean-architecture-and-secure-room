package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.data.database.entity.PersonEntity

@Dao
interface PersonDao : BaseDao<PersonEntity> {

    @Query(value = "SELECT * FROM personTable WHERE id = :id LIMIT 1")
    suspend fun getPerson(id: Int): PersonEntity?

    @Query(value = "SELECT * FROM personTable")
    suspend fun getAllPerson(): List<PersonEntity?>

    @Query(value = "DELETE FROM personTable WHERE id = :id")
    suspend fun deleteOne(id: Int)

}