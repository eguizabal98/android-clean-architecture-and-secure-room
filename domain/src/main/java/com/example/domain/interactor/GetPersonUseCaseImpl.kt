package com.example.domain.interactor

import com.example.domain.domain.Person
import com.example.domain.domain.Result
import com.example.domain.repository.PersonRepository

class GetPersonUseCaseImpl(private val personRepository: PersonRepository) : GetPersonUseCase {
    override suspend fun invoke(id: Int): Result<Person?> = personRepository.getPerson(id)
}