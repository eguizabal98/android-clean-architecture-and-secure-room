package com.example.data.database

import com.example.data.database.entity.PersonEntity
import com.example.domain.domain.Person

fun PersonEntity.mapToDomain(): Person = Person(id, name, secondName, age)

fun Person.mapToDB(): PersonEntity = PersonEntity(id, name, secondName, age)