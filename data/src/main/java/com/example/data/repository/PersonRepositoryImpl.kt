package com.example.data.repository

import com.example.data.database.dao.PersonDao
import com.example.data.database.mapToDB
import com.example.data.database.mapToDomain
import com.example.domain.domain.Person
import com.example.domain.domain.Result
import com.example.domain.repository.PersonRepository

class PersonRepositoryImpl(private val personDao: PersonDao) : PersonRepository, BaseRepository() {

    override suspend fun savePerson(person: Person): Result<Person> {
        return dbOperation {
            personDao.insertEntity(person.mapToDB())
            Result.Success(person)
        }
    }

    override suspend fun getPerson(id: Int): Result<Person?> {
        return dbOperation {
            val response = personDao.getPerson(id)?.mapToDomain()
            Result.Success(response)
        }
    }

    override suspend fun getAllPerson(): Result<List<Person?>> {
        return dbOperation {
            val response = personDao.getAllPerson().map {
                it?.mapToDomain()
            }
            Result.Success(response)
        }
    }

    override suspend fun updatePerson(person: Person): Result<Person> {
        return dbOperation {
            personDao.updateEntity(person.mapToDB())
            Result.Success(person)
        }
    }

    override suspend fun deletePerson(id: Int): Result<Boolean> {
        return dbOperation {
            personDao.deleteOne(id)
            Result.Success(true)
        }
    }
}