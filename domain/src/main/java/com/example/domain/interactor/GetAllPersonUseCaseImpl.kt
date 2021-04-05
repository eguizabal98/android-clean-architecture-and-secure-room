package com.example.domain.interactor

import com.example.domain.domain.Person
import com.example.domain.domain.Result
import com.example.domain.repository.PersonRepository

class GetAllPersonUseCaseImpl(private val personRepository: PersonRepository) :
    GetAllPersonUseCase {
    override suspend fun invoke(): Result<List<Person?>> = personRepository.getAllPerson()
}