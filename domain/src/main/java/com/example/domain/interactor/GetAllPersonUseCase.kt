package com.example.domain.interactor

import com.example.domain.domain.Person
import com.example.domain.domain.Result

interface GetAllPersonUseCase {
    suspend operator fun invoke(): Result<List<Person?>>
}