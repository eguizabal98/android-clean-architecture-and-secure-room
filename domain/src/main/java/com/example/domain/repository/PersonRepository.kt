package com.example.domain.repository

import com.example.domain.domain.Person
import com.example.domain.domain.Result

interface PersonRepository {
    suspend fun savePerson(person: Person): Result<Person>
    suspend fun getPerson(id: Int): Result<Person?>
    suspend fun getAllPerson(): Result<List<Person?>>
    suspend fun updatePerson(person: Person): Result<Person>
    suspend fun deletePerson(id: Int): Result<Boolean>
}