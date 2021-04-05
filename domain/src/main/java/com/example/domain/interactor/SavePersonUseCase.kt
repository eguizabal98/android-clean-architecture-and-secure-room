package com.example.domain.interactor

import com.example.domain.domain.Person
import com.example.domain.domain.Result

interface SavePersonUseCase {
    suspend operator fun invoke(person: Person): Result<Person>
}