package com.example.domain.interactor

import com.example.domain.domain.Person
import com.example.domain.domain.Result
import com.example.domain.repository.PersonRepository

class UpdatePersonUseCaseImpl(private val personRepository: PersonRepository) :
    UpdatePersonUseCase {
    override suspend fun invoke(person: Person): Result<Person> =
        personRepository.updatePerson(person)
}