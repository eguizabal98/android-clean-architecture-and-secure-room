package com.example.domain.interactor

import com.example.domain.domain.Person
import com.example.domain.domain.Result
import com.example.domain.repository.PersonRepository

class SavePersonUseCaseImpl(private val personRepository: PersonRepository) : SavePersonUseCase {
    override suspend fun invoke(person: Person): Result<Person> =
        personRepository.savePerson(person)
}