package com.example.domain.interactor

import com.example.domain.domain.Result
import com.example.domain.repository.PersonRepository

class DeletePersonUseCaseImpl(private val personRepository: PersonRepository) :
    DeletePersonUseCase {
    override suspend fun invoke(id: Int): Result<Boolean> = personRepository.deletePerson(id)
}