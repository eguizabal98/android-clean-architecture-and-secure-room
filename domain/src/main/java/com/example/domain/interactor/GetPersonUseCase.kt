package com.example.domain.interactor

import com.example.domain.domain.Person
import com.example.domain.domain.Result

interface GetPersonUseCase {
    suspend operator fun invoke(id: Int): Result<Person?>
}