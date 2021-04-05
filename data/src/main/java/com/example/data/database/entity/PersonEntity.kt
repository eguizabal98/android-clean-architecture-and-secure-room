package com.example.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.domain.Person

@Entity(tableName = "PersonTable")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String,
    var secondName: String,
    var age: Int
)

